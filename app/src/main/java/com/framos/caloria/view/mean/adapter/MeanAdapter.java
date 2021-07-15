package com.framos.caloria.view.mean.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.framos.caloria.R;
import com.framos.caloria.model.Mean;
import com.framos.caloria.view.mean.holder.MeanHolder;
import com.framos.caloria.view.mean.listener.MeanClickListener;

public class MeanAdapter extends RecyclerView.Adapter<MeanHolder> {
    Mean mean;
    Context context;
    MeanClickListener meanClickListener;

    public MeanAdapter(Mean mean, Context context, MeanClickListener meanClickListener) {
        this.mean = mean;
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
       // holder.itemMeanName.setText(mean.getListFood().get(position).getDescricaoPrincipal());
    }

    @Override
    public int getItemCount() {
        return mean.getListFood().size();
    }
}
