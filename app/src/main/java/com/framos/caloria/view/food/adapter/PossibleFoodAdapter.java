package com.framos.caloria.view.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.FocusDelegate;
import androidx.recyclerview.widget.RecyclerView;

import com.framos.caloria.R;
import com.framos.caloria.model.Food;
import com.framos.caloria.model.Mean;
import com.framos.caloria.view.mean.holder.MeanHolder;
import com.framos.caloria.view.mean.listener.MeanClickListener;

import java.util.List;

public class PossibleFoodAdapter extends RecyclerView.Adapter<MeanHolder> {
    List<Food> listFood;
    Context context;
    MeanClickListener meanClickListener;

    public PossibleFoodAdapter(List<Food> listFood, Context context, MeanClickListener meanClickListener) {
        this.listFood = listFood;
        this.context = context;
        this.meanClickListener = meanClickListener;
    }

    @NonNull
    @Override
    public MeanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeanHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mean, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeanHolder holder, int position) {
         holder.itemMeanName.setText(listFood.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }
}
