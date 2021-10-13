package com.framos.caloria.view.mean.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
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
import com.framos.caloria.view.login.LoginActivity;
import com.framos.caloria.view.mean.adapter.MeanAdapter;
import com.framos.caloria.view.mean.listener.MeanClickListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class MeanActivity extends AppCompatActivity {
    private View viewInfo;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter meanAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MaterialButton btnAddMean;
    private TextView textNoFood;
    private Mean mean;
    private MaterialTextView title;
    private ImageFilterButton btnBack;
    private TextView txtQdtAlimentos, txtCaloriasKcal, txtEnergiaKj, txtProteinaG, txtColesterolMg, txtCarboIdratoG;

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
        if (Aplication.foodList != null && !Aplication.foodList.isEmpty()) {
            mean.setListFood(Aplication.foodList);
            textNoFood.setVisibility(View.GONE);
            viewInfo.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            List<Food> foods = Aplication.foodList;
            setViewInfo(foods);
            initAdapter();
        } else {
            recyclerView.setVisibility(View.INVISIBLE);
            textNoFood.setVisibility(View.VISIBLE);
            viewInfo.setVisibility(View.INVISIBLE);
        }
    }

    private void setViewInfo(List<Food> foods) {
        int qtd = foods.size();
        double calorasKcal = 0;
        double energiaKj = 0;
        double proteinaG = 0;
        double colesterolMg = 0;
        double carboIdratoG = 0;
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getEnergiaKcal() != null) {
                calorasKcal = calorasKcal + Double.valueOf(foods.get(i).getEnergiaKcal());
            }
            if (foods.get(i).getEnergiaKJ() != null) {
                energiaKj = energiaKj + Double.valueOf(foods.get(i).getEnergiaKJ());
            }
            if (foods.get(i).getProteinaG() != null) {
                proteinaG = proteinaG + Double.valueOf(foods.get(i).getProteinaG());
            }
            if (foods.get(i).getColesterolMg() != null) {
                colesterolMg = colesterolMg + Double.valueOf(foods.get(i).getColesterolMg());
            }
            if (foods.get(i).getCarboIdratoG() != null) {
                carboIdratoG = carboIdratoG + Double.valueOf(foods.get(i).getCarboIdratoG());
            }
        }
        txtQdtAlimentos.setText(String.valueOf(qtd));
        txtCaloriasKcal.setText(String.valueOf(calorasKcal));
        txtEnergiaKj.setText(String.valueOf(energiaKj));
        txtProteinaG.setText(String.valueOf(colesterolMg));
        txtColesterolMg.setText(String.valueOf(colesterolMg));
        txtCarboIdratoG.setText(String.valueOf(carboIdratoG));
    }

    private void initView() {
        title = findViewById(R.id.title_base_acitivty);
        title.setText(R.string.mean);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        txtQdtAlimentos = findViewById(R.id.txt_qdt_alimentos);
        txtCaloriasKcal = findViewById(R.id.txt_calorias_kcal);
        txtEnergiaKj = findViewById(R.id.txt_energia_kj);
        txtProteinaG = findViewById(R.id.txt_proteinaG);
        txtColesterolMg = findViewById(R.id.txt_colesterolMg);
        txtCarboIdratoG = findViewById(R.id.txt_carboIdratoG);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_mean);
        textNoFood = findViewById(R.id.text_no_food);
        btnAddMean = findViewById(R.id.btn_add_mean);
        viewInfo = findViewById(R.id.view_mean_info);
        btnAddMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFoodAcitivty();
            }
        });
        getMean();
    }

    private void logout() {
        finish();
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
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
        meanAdapter.notifyDataSetChanged();
    }
}