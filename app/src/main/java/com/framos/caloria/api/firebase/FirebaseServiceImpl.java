package com.framos.caloria.api.firebase;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServiceImpl implements FirebaseService {
    private static FirebaseAuth mAuth;
    private static FirebaseFirestore db;
    private static FirebaseStorage storage;
    private static FirebaseDatabase realTimeDatabse;

    @Override
    public FirebaseAuth getFirebaseAutenticacao() {
        if (mAuth == null) {
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }

    @Override
    public FirebaseFirestore getFirebaseDatabase() {
        if (db == null) {
            db = FirebaseFirestore.getInstance();
        }
        return db;
    }

    @Override
    public FirebaseStorage getFirebaseStorage() {
        if (storage == null) {
            storage = FirebaseStorage.getInstance();
        }
        return storage;
    }

    @Override
    public FirebaseDatabase getFirebaseRealTimeDatabse() {
        if (realTimeDatabse == null) {
            realTimeDatabse = FirebaseDatabase.getInstance();
        }
        return realTimeDatabse;
    }

}
