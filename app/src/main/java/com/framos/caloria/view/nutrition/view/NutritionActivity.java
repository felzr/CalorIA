package com.framos.caloria.view.nutrition.view;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.framos.caloria.R;
import com.framos.caloria.api.firebase.FirebaseService;
import com.framos.caloria.api.firebase.FirebaseServiceImpl;
import com.framos.caloria.model.Food;
import com.framos.caloria.view.Aplication;
import com.framos.caloria.view.login.LoginActivity;
import com.framos.caloria.view.mean.activity.MeanActivity;
import com.google.android.material.button.MaterialButton;

public class NutritionActivity extends AppCompatActivity {
    private ImageView img;
    private byte[] foodImage;
    private TextView txtClasses, txtCaloriasKcal, txtEnergiaKj, txtProteinaG, txtColesterolMg, txtCarboIdratoG;
    private MaterialButton btnAddFood;
    FirebaseService firebaseService = new FirebaseServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        Food food = (Food) intent.getSerializableExtra("food");
        foodImage = intent.getByteArrayExtra("foodImage");
        img = findViewById(R.id.img_food);
        img.setImageBitmap(BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length));
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
        btnAddFood = findViewById(R.id.btn_add_food);
        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aplication.foodList.add(food);
                finish();
                Intent i = new Intent(getApplicationContext(), MeanActivity.class);
                startActivity(i);
            }
        });
    }
}