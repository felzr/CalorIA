package com.framos.caloria.view.food.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.framos.caloria.R;

public class PossibleFoodHolder extends RecyclerView.ViewHolder {

    public TextView itemMeanName;

    public PossibleFoodHolder(@NonNull View itemView) {
        super(itemView);
        itemView = itemView.findViewById(R.id.text_item_food);
    }
}
