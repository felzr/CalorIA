package com.framos.caloria.view.food.activity;

import androidx.annotation.RequiresApi;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.ImageReader;
import android.os.Build;
import android.os.SystemClock;
import android.util.Size;
import android.util.TypedValue;
import com.framos.caloria.R;
import com.framos.caloria.api.cnnApi.tensorflow.Classifier;
import com.framos.caloria.utils.BorderedText;
import com.framos.caloria.view.base.CameraActivity;


import java.io.IOException;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FoodActivity  extends CameraActivity implements ImageReader.OnImageAvailableListener {
    private static final Size DESIRED_PREVIEW_SIZE = new Size(640, 480);
    private static final float TEXT_SIZE_DIP = 10;
    private Bitmap rgbFrameBitmap = null;
    private long lastProcessingTimeMs;
    private Integer sensorOrientation;
    private Classifier classifier;
    private BorderedText borderedText;
    /**
     * Input image size of the model along x axis.
     */
    private int imageSizeX;
    /**
     * Input image size of the model along y axis.
     */
    private int imageSizeY;

    @Override
    protected int getLayoutId() {
        return R.layout.camera_connection_fragment;
    }

    @Override
    protected Size getDesiredPreviewFrameSize() {
        return DESIRED_PREVIEW_SIZE;
    }

    @Override
    public void onPreviewSizeChosen(final Size size, final int rotation) {
        final float textSizePx =
                TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
        borderedText = new BorderedText(textSizePx);
        borderedText.setTypeface(Typeface.MONOSPACE);

        recreateClassifier(getDevice(), getNumThreads());
        if (classifier == null) {
            return;
        }

        previewWidth = size.getWidth();
        previewHeight = size.getHeight();

        sensorOrientation = rotation - getScreenOrientation();

        rgbFrameBitmap = Bitmap.createBitmap(previewWidth, previewHeight, Bitmap.Config.ARGB_8888);
    }

    @Override
    protected void processImage() {
        rgbFrameBitmap.setPixels(getRgbBytes(), 0, previewWidth, 0, 0, previewWidth, previewHeight);
        final int cropSize = Math.min(previewWidth, previewHeight);

        runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        if (classifier != null) {
                            final long startTime = SystemClock.uptimeMillis();
                            final List<Classifier.Recognition> results =
                                    classifier.recognizeImage(rgbFrameBitmap, sensorOrientation);
                            lastProcessingTimeMs = SystemClock.uptimeMillis() - startTime;
                            if (100 * results.get(0).getConfidence()>60.0){
                                food = results.get(0);
                                runOnUiThread(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                showResultsInBottomSheet(results);
                                                capturePicture(rgbFrameBitmap);
                                            }
                                        });
                            }else{
                                readyForNextImage();
                            }
                        }

                    }

                });
    }


    @Override
    protected void onInferenceConfigurationChanged() {
        if (rgbFrameBitmap == null) {
            return;
        }
        final Classifier.Device device = getDevice();
        final int numThreads = getNumThreads();
        runInBackground(() -> recreateClassifier(device, numThreads));
    }

    private void recreateClassifier(Classifier.Device device, int numThreads) {
        if (classifier != null) {
            classifier.close();
            classifier = null;
        }
        try {
            classifier = Classifier.create(this, device, numThreads);
        } catch (IOException e) {
        }

        // Updates the input image size.
        imageSizeX = classifier.getImageSizeX();
        imageSizeY = classifier.getImageSizeY();
    }
}