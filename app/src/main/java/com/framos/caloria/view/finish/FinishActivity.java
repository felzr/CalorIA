package com.framos.caloria.view.finish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import com.framos.caloria.R;
import com.framos.caloria.model.Food;
import com.google.android.material.textview.MaterialTextView;

public class FinishActivity extends AppCompatActivity {
    private TextView txtClasses, txtCaloriasKcal, txtEnergiaKj, txtProteinaG, txtColesterolMg, txtCarboIdratoG, textFoodName;
    private MaterialTextView title;
    private ImageFilterButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        Food food = (Food) intent.getSerializableExtra("total");
        textFoodName.setText(food.getDescricao());
        txtClasses = findViewById(R.id.txt_classes);
        txtClasses.setText(food.getClasses());
        txtCaloriasKcal = findViewById(R.id.txt_calorias_kcal);
        txtCaloriasKcal.setText(food.getEnergiaKcal());
        txtEnergiaKj = findViewById(R.id.txt_energia_kj);
        txtEnergiaKj.setText(food.getEnergiaKJ());
        txtProteinaG = findViewById(R.id.txt_proteinaG);
        txtProteinaG.setText(food.getProteinaG());
        txtColesterolMg = findViewById(R.id.txt_colesterolMg);
        txtColesterolMg.setText(food.getColesterolMg());
        txtCarboIdratoG = findViewById(R.id.txt_carboIdratoG);
        txtCarboIdratoG.setText(food.getCarboIdratoG());
    }
}