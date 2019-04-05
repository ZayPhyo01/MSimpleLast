package com.example.msimple.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msimple.R;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.view.holders.CategoryHolder;

public class CategoryAdapter extends BaseAdapter<CategoryHolder, CategoryVO> {


    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_category,viewGroup,false);
        return new CategoryHolder(view);
    }
}
