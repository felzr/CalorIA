package com.framos.caloria.model;

import androidx.annotation.NonNull;

public class Recognition {
    public String id = "";
    public String title = "";
    public float confidence = 0F;

    public Recognition(String i, String s, float confidence) {
        id = i;
        title = s;
        this.confidence = confidence;
    }

    @NonNull
    @Override
    public String toString() {
        return "Title = " + title + ", Confidence = " + confidence;
    }
}
