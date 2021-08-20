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
import com.framos.caloria.view.Aplication;
import com.framos.caloria.view.food.activity.FoodActivity;
import com.framos.caloria.view.mean.adapter.MeanAdapter;
import com.framos.caloria.view.mean.listener.MeanClickListener;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MeanActivity extends AppCompatActivity {
    private View viewNotFood,view_mean_info;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter meanAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MaterialButton btnAddMean;
    private TextView textNoFood;
    private Mean mean;
    private TextView txtQdtAlimentos, txtCaloriasKcal, txtEnergiaKj, txtProteinaG, txtColesterolMg, txtCarboIdratoG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean);
        initView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getMean();
    }

    private void getMean() {
        mean = new Mean();
        if (Aplication.foodList != null &&!Aplication.foodList.isEmpty()) {
            mean.setListFood(Aplication.foodList);
            viewNotFood.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            view_mean_info.setVisibility(View.VISIBLE);
            List<Food> foods = Aplication.foodList;
            setViewInfo(foods);
            initAdapter();
        } else {
            viewNotFood.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
            viewNotFood.setVisibility(View.INVISIBLE);
        }
    }

    private void setViewInfo(List<Food> foods) {
        int qtd = foods.size();
        double calorasKcal = 0;
        for (int i = 0; i <= foods.size(); i++) {
            //calorasKcal = Double.valueOf(calorasKcal+foods.get(i).getEnergiaKcal());
        }
        txtQdtAlimentos.setText(String.valueOf(qtd));
        //txtCaloriasKcal.setText(String.valueOf(calorasKcal));
    }

    private void initView() {
        txtQdtAlimentos = findViewById(R.id.txt_qdt_alimentos);
        txtCaloriasKcal = findViewById(R.id.txt_calorias_kcal);
        txtEnergiaKj = findViewById(R.id.txt_energia_kj);
        txtProteinaG = findViewById(R.id.txt_proteinaG);
        txtColesterolMg = findViewById(R.id.txt_colesterolMg);
        txtCarboIdratoG = findViewById(R.id.txt_carboIdratoG);
        viewNotFood = findViewById(R.id.view_not_food);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_mean);
        textNoFood = findViewById(R.id.text_no_food);
        btnAddMean = findViewById(R.id.btn_add_mean);
        view_mean_info = findViewById(R.id.view_mean_info);
        btnAddMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFoodAcitivty();
            }
        });
    }

    private void callFoodAcitivty() {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
        finish();
    }

    private void initAdapter() {
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