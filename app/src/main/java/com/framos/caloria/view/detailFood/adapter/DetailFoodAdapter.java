package com.framos.caloria.view.detailFood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.FocusDelegate;
import androidx.recyclerview.widget.RecyclerView;

import com.framos.caloria.R;
import com.framos.caloria.model.Food;
import com.framos.caloria.view.detailFood.holder.DetailFoodHolder;
import com.framos.caloria.view.detailFood.listner.FoodClickListner;
import com.framos.caloria.view.mean.holder.MeanHolder;

import java.util.List;

public class DetailFoodAdapter extends RecyclerView.Adapter<DetailFoodHolder> {
    List<Food> foodList;
    Context context;
    FoodClickListner foodClickListner;

    public DetailFoodAdapter(List<Food> foodList, Context context, FoodClickListner foodClickListner) {
        this.context = context;
        this.foodClickListner = foodClickListner;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public DetailFoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailFoodHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailFoodHolder holder, int position) {
        holder.itemFoodName.setText(foodList.get(position).getDescricao());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodClickListner.click(foodList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
