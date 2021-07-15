package com.framos.caloria.view.register;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.framos.caloria.R;
import com.framos.caloria.controller.UserControler;
import com.framos.caloria.controller.UserControllerImpl;
import com.framos.caloria.model.User;
import com.framos.caloria.utils.Base64Converter;
import com.framos.caloria.view.base.BaseActivity;
import com.framos.caloria.view.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.DocumentReference;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RegisterActivity extends BaseActivity {
    TextInputEditText email, user, password, confirmPassword;
    MaterialButton btnRegister, btnClearTexts;
    UserControler loginControler = new UserControllerImpl();
    private static final String TAG = "Register";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        initBase(R.string.register);
        email = findViewById(R.id.edt_email);
        user = findViewById(R.id.edt_user);
        password = findViewById(R.id.edt_password);
        confirmPassword = findViewById(R.id.edt_confirm_password);
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evalUser();
            }
        });
        btnClearTexts = findViewById(R.id.btn_clear);
        btnClearTexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTexts();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();

    }

    private void evalUser() {
        User user = new User();
        user.setEmail(email.getText().toString());
        user.setUser(user.getUser().toString());
        user.setPassword(password.getText().toString());
        if (!user.getEmail().equals("") && !user.getUser().equals("")
                && !user.getPassword().equals("") && !confirmPassword.getText().toString().equals("")) {
            if (user.getPassword().equals(confirmPassword.getText().toString())) {
                register(user);
            } else {
                Toast.makeText(RegisterActivity.this, "Senha divergente da confirmação ", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(RegisterActivity.this, "Preencha todos os campos: ", Toast.LENGTH_LONG).show();
        }
    }

    private void register(User user) {
        loginControler.getLoginService().createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Sucesso ao cadastrar usuário", Toast.LENGTH_LONG).show();
                    String identificadorUsuario = Base64Converter.codeBase64(user.getEmail());
                    user.setId(identificadorUsuario);
                    user.setPassword("");
                    saveLocalUser(user);
                    saveFirestoreUser(user);
                } else {
                    Toast.makeText(RegisterActivity.this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void saveLocalUser(User user) {
        loginControler.saveUser(user);
    }

    private void saveFirestoreUser(User user) {
        loginControler.saveUserInFirebase().collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });
    }

    private void clearTexts() {
        email.setText("");
        password.setText("");
        confirmPassword.setText("");
    }


}