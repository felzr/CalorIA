package com.framos.caloria.data;

import android.content.Context;

import com.framos.caloria.model.User;

public class SharedPreferences {
    private Context context;
    private android.content.SharedPreferences preferences;
    private final String FILE_NAME = "calorIA.preferences";
    private final int MODE = 0;
    private android.content.SharedPreferences.Editor editor;

    private final String KEY_ID = "KEY_ID";
    private final String KEY_EMAIL = "KEY_EMAIL";
    private final String KEY_USER = "KEY_USER";

    public SharedPreferences(Context contextoParametro) {
        context = contextoParametro;
        preferences = context.getSharedPreferences(FILE_NAME, MODE);
        editor = preferences.edit();

    }

    public void salveData(User user) {
        editor.putString(KEY_ID, user.getId());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_USER, user.getUser());
        editor.commit();

    }

    public String getId() {
        return preferences.getString(KEY_ID, null);
    }

    public String getEmail() {
        return preferences.getString(KEY_EMAIL, null);
    }
}
