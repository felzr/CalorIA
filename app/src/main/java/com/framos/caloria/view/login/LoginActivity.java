package com.framos.caloria.view.login;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.framos.caloria.R;
import com.framos.caloria.controller.UserControler;
import com.framos.caloria.controller.UserControllerImpl;
import com.framos.caloria.utils.Permition;
import com.framos.caloria.view.mean.activity.MeanActivity;
import com.framos.caloria.view.register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity {
    MaterialTextView btnCreateAcount;
    TextInputEditText edtLogin;
    TextInputEditText edtLoginPassword;
    MaterialButton btnLogin;
    MaterialButton btnClearTexts;
    UserControler loginControler = new UserControllerImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkPermission();
        initView();
    }

    private void initView() {
        btnCreateAcount = findViewById(R.id.btn_create_acount);
        btnCreateAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });
        edtLogin = findViewById(R.id.edt_login);
        edtLoginPassword = findViewById(R.id.edt__login_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnClearTexts = findViewById(R.id.btn_clear);
        btnClearTexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputText();
            }
        });
    }

    private void login() {
        String email = edtLogin.getText().toString();
        String password = edtLoginPassword.getText().toString();
        if (email.equals("") && password.equals("")) {
            Toast.makeText(LoginActivity.this, "E-mail e senha são obrigatórios", Toast.LENGTH_LONG).show();
        } else {
            loginControler.getLoginService().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        callMain();
                        Toast.makeText(LoginActivity.this, "Sucesso ao fazer login!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "The password is invalid or the user does not have a password.", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }

    private void callMain() {
        Intent intent = new Intent(this, MeanActivity.class);
        startActivity(intent);
        finish();
    }

    private void callRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    void clearInputText() {
        edtLogin.setText("");
        edtLoginPassword.setText("");
    }

    void checkPermission() {
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA
        };
        Permition.validPermitions(PERMISSION_ALL, LoginActivity.this, PERMISSIONS);
    }

}