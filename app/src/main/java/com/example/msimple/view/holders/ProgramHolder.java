package com.example.msimple.view.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.msimple.Delegate.OnClickItem;
import com.example.msimple.R;
import com.example.msimple.data.vos.ProgramVO;

import java.util.List;

public class ProgramHolder extends BaseHolder<ProgramVO> {

    TextView tvItemTitle;

    OnClickItem onClickItem;
    ProgramVO programVO;


    public ProgramHolder(@NonNull View itemView, OnClickItem onClickItem) {
        super(itemView);

        this.onClickItem = onClickItem;

        tvItemTitle = itemView.findViewById(R.id.tv_item_time);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        onClickItem.onTap(programVO);


    }

    @Override
    public void bind(ProgramVO data) {
        programVO = data;
        tvItemTitle.setText(data.getTitle());

    }
}
