package com.framos.caloria.view;

import android.app.Application;

import com.framos.caloria.model.FirebaseObject.FoodTaco;
import com.framos.caloria.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Aplication extends Application {
    public static String emailLogado;
    public static List<Food> foodList = new ArrayList<>();
}
