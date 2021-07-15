package com.framos.caloria.controller;

import com.framos.caloria.api.firebase.FirebaseService;
import com.framos.caloria.api.firebase.FirebaseServiceImpl;
import com.framos.caloria.data.SharedPreferences;
import com.framos.caloria.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class UserControllerImpl implements UserControler {
    FirebaseService firebaseService = new FirebaseServiceImpl();
    SharedPreferences preferencesService;

    @Override
    public FirebaseAuth getLoginService() {
        return firebaseService.getFirebaseAutenticacao();
    }

    @Override
    public void saveUser(User user) {
        preferencesService.salveData(user);
    }

    @Override
    public FirebaseFirestore saveUserInFirebase() {
        return firebaseService.getFirebaseDatabase();
    }
}
