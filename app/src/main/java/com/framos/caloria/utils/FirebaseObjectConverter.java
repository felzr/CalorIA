package com.framos.caloria.utils;

import com.framos.caloria.model.FirebaseObject.FoodTaco;
import com.framos.caloria.model.Food;

import java.util.ArrayList;
import java.util.List;

public  class FirebaseObjectConverter {

   public List<Food> convertListFoodTaco(List<FoodTaco> list) {
        List<Food> listFood = new ArrayList<>();
        for (FoodTaco foodTaco : list) {
            Food food = new Food();
            food.setFood_id(foodTaco.food_id);
            food.setClasses(foodTaco.classes);
            food.setDescricao(foodTaco.descricao);
            food.setEnergiaKcal(foodTaco.energiaKcal);
            food.setEnergiaKJ(foodTaco.energiaKJ);
            food.setProteinaG(foodTaco.proteinaG);
            food.setCarboIdratoG(foodTaco.carboIdratoG);
            listFood.add(food);
        }
        return listFood;
    }
}
