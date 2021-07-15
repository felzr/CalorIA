package com.framos.caloria.controller;


import com.framos.caloria.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public interface UserControler {

    FirebaseAuth getLoginService();

    void saveUser(User user);

    FirebaseFirestore saveUserInFirebase();

}
