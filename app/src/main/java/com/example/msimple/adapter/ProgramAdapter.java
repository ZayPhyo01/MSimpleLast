package com.example.msimple.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msimple.Delegate.OnClickItem;
import com.example.msimple.R;
import com.example.msimple.data.vos.ProgramVO;
import com.example.msimple.view.holders.BaseHolder;
import com.example.msimple.view.holders.ProgramHolder;

public class ProgramAdapter extends BaseAdapter<ProgramHolder, ProgramVO> {


    OnClickItem onClickItem;
    public ProgramAdapter(OnClickItem clickItem) {
        onClickItem = clickItem;
    }

    @NonNull
    @Override
    public ProgramHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_program,viewGroup,false);
        return new ProgramHolder(view,onClickItem);
    }
}
