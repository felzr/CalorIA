package com.framos.caloria.view.detailFood.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.framos.caloria.R;
import com.framos.caloria.controller.FoodController;
import com.framos.caloria.controller.FoodControllerImpl;
import com.framos.caloria.model.FirebaseObject.FoodTaco;
import com.framos.caloria.model.Food;
import com.framos.caloria.utils.FirebaseObjectConverter;
import com.framos.caloria.view.base.BaseActivity;
import com.framos.caloria.view.detailFood.adapter.DetailFoodAdapter;
import com.framos.caloria.view.detailFood.listner.FoodClickListner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {
    private FoodController foodController = new FoodControllerImpl();
    private FirebaseObjectConverter firebaseObjectConverter;
    private RecyclerView.Adapter detailFoodAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firebaseObjectConverter = new FirebaseObjectConverter();
        recyclerView = findViewById(R.id.recycler_food);
        findFood(getFoodKey());
    }

    String getFoodKey() {
        Intent intent = getIntent();
        return intent.getStringExtra("selectedFood");
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
                System.out.println(food.getDescricao());
            }
        });
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(detailFoodAdapter);


    }
}