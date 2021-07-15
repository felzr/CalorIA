package com.framos.caloria.api.firebase;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public interface FirebaseService {

    FirebaseAuth getFirebaseAutenticacao();

    FirebaseFirestore getFirebaseDatabase();

    FirebaseStorage getFirebaseStorage();

    FirebaseDatabase getFirebaseRealTimeDatabse();


}
