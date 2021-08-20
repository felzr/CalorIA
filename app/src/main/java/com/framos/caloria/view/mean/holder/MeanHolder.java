package com.framos.caloria.view.mean.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.framos.caloria.R;

public class MeanHolder extends RecyclerView.ViewHolder {

    public TextView itemMeanName;

    public MeanHolder(@NonNull View itemView) {
        super(itemView);
        itemMeanName = itemView.findViewById(R.id.text_item_mean);
    }
}
