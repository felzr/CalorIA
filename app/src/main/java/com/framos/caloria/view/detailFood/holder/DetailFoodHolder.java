package com.framos.caloria.view.detailFood.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.framos.caloria.R;

public class DetailFoodHolder extends RecyclerView.ViewHolder{
    public TextView itemFoodName;

    public DetailFoodHolder(@NonNull View itemView) {
        super(itemView);
        itemFoodName = itemView.findViewById(R.id.text_item_food);
    }
}
