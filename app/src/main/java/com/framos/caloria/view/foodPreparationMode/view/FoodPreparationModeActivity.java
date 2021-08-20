package com.framos.caloria.view.foodPreparationMode.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.framos.caloria.R;
import com.framos.caloria.controller.FoodController;
import com.framos.caloria.controller.FoodControllerImpl;
import com.framos.caloria.model.FirebaseObject.FoodTaco;
import com.framos.caloria.model.Food;
import com.framos.caloria.utils.FirebaseObjectConverter;
import com.framos.caloria.view.foodPreparationMode.adapter.DetailFoodAdapter;
import com.framos.caloria.view.foodPreparationMode.listner.FoodClickListner;
import com.framos.caloria.view.nutrition.view.NutritionActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.List;

public class FoodPreparationModeActivity extends AppCompatActivity {
    private FoodController foodController = new FoodControllerImpl();
    private FirebaseObjectConverter firebaseObjectConverter;
    private RecyclerView.Adapter detailFoodAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private LinearLayout viewList;
    private byte[] foodImage;
    private ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_preparation_mode);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewList = findViewById(R.id.view_list);
        firebaseObjectConverter = new FirebaseObjectConverter();
        recyclerView = findViewById(R.id.recycler_food);
        Intent intent = getIntent();
        String foodName = intent.getStringExtra("selectedFood");
        foodImage = intent.getByteArrayExtra("foodImage");
        img = findViewById(R.id.img_food);
        img.setImageBitmap(BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length));
        findFood(foodName);
    }



    private void findFood(String value) {
        CollectionReference food = foodController.getFoodService().collection("food_taco");
        Task<QuerySnapshot> tacoRef = food.whereEqualTo("descricaoPrincipal", value).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<FoodTaco> f = task.getResult().toObjects(FoodTaco.class);
                initAdapter(f);
            }
        });


    }


    private void initAdapter(List<FoodTaco> f) {
        List<Food> listFoods = firebaseObjectConverter.convertListFoodTaco(f);
        detailFoodAdapter = new DetailFoodAdapter(listFoods, getApplicationContext(), new FoodClickListner() {
            @Override
            public void click(Food food) {
                initViewFoodDetail(food);
            }
        });
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(detailFoodAdapter);


    }

    private void initViewFoodDetail(Food food) {
        Intent intent = new Intent(getApplicationContext(), NutritionActivity.class);
        intent.putExtra("food", food);
        intent.putExtra("foodImage",foodImage);
        startActivity(intent);
        finish();
    }
}