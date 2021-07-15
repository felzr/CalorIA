package com.framos.caloria.controller;

import com.framos.caloria.api.firebase.FirebaseService;
import com.framos.caloria.api.firebase.FirebaseServiceImpl;
import com.google.firebase.firestore.FirebaseFirestore;

public class FoodControllerImpl implements FoodController {
    FirebaseService firebaseService = new FirebaseServiceImpl();

    @Override
    public FirebaseFirestore getFoodService() {
        return firebaseService.getFirebaseDatabase();
    }
}
