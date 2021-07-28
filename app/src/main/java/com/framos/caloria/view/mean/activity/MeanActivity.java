package com.framos.caloria.view.mean.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.framos.caloria.R;
import com.framos.caloria.model.FirebaseObject.FoodTaco;
import com.framos.caloria.model.Food;
import com.framos.caloria.model.Mean;
import com.framos.caloria.view.food.activity.FoodActivity;
import com.framos.caloria.view.mean.adapter.MeanAdapter;
import com.framos.caloria.view.mean.listener.MeanClickListener;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MeanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter meanAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MaterialButton btnAddMean;
    private TextView textNoFood;
    private Mean mean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean);
        initView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void getMean() {
        mean = new Mean();
      // mean.setListFood(Aplication.foodList);
       if (mean.getListFood()== null){
           List<Food> list = new ArrayList<>();
           mean.setListFood(list);
       }
       if (mean.getListFood() != null && mean.getListFood().isEmpty()){
//           textNoFood.setVisibility(View.INVISIBLE);
//           recyclerView.setVisibility(View.VISIBLE);
       }
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_mean);
        textNoFood = findViewById(R.id.text_no_food);
        btnAddMean = findViewById(R.id.btn_add_mean);
        btnAddMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              callFoodAcitivty();
            }
        });
        initAdapter();
    }

    private void callFoodAcitivty() {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
        finish();
    }

    private void initAdapter() {
        getMean();
        meanAdapter = new MeanAdapter(mean, getApplicationContext(), new MeanClickListener() {
            @Override
            public void clickItemMean(FoodTaco food) {
            }
        });
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(meanAdapter);
    }
}