package com.framos.caloria.view.splash;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.framos.caloria.R;
import com.framos.caloria.view.login.LoginActivity;
import com.google.firebase.FirebaseApp;

public class SplashAcitivty extends AppCompatActivity {
    private ImageView splashImage;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acitivty);
        loadView();
        setFlags();
    }

    private void loadView() {
        splashImage = findViewById(R.id.SplashScreenImage);
        animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        splashImage.startAnimation(animation);
        startApp();
    }

    private void startApp() {
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                callLogin();
            }
        }, 5000);

    }

    private void callLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void setFlags() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}