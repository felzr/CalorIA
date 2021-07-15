package com.framos.caloria.view.base;



import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import com.framos.caloria.R;
import com.google.android.material.textview.MaterialTextView;

public abstract class BaseActivity extends Activity {
    protected View viewBar;
    protected ImageFilterButton btnBack;
    protected MaterialTextView title;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBar();
    }
     protected void initBase(int resource){
       title = findViewById(R.id.title_base_acitivty);
       title.setText(resource);
       btnBack = findViewById(R.id.btn_back);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setBar() {
        viewBar = (Toolbar) findViewById(R.id.simple_bar);
        if (viewBar != null) {
            setActionBar((android.widget.Toolbar) viewBar);
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
