package com.example.msimple.view.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHolder<T>extends RecyclerView.ViewHolder implements View.OnClickListener {

    public BaseHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void bind(T data);


    @Override
    public void onClick(View v)
    {

    }
}
