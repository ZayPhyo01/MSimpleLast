package com.example.msimple.view.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msimple.Delegate.OnClickItem;
import com.example.msimple.R;
import com.example.msimple.adapter.ProgramAdapter;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.ProgramVO;

public class CategoryHolder extends BaseHolder<CategoryVO> {

RecyclerView recyclerView;
ProgramAdapter programAdapter;
OnClickItem onClickItem;
    public CategoryHolder(@NonNull View itemView, final OnClickItem onClickItem) {
        super(itemView);
        this.onClickItem = onClickItem;
        recyclerView = itemView.findViewById(R.id.rv_category_program);
        programAdapter = new ProgramAdapter(onClickItem);
        recyclerView.setAdapter(programAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));

    }



    @Override
    public void bind(CategoryVO data) {
        Log.d("CategoryHolderTitle",data.getTitle());
        programAdapter.setNewData(data.getPrograms());

    }






}
