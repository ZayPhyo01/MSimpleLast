package com.example.msimple.view.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.msimple.R;
import com.example.msimple.data.vos.ProgramVO;

public class ProgramHolder extends BaseHolder<ProgramVO> {

    TextView tvItemTitle;

    public ProgramHolder(@NonNull View itemView) {
        super(itemView);
        tvItemTitle = itemView.findViewById(R.id.tv_item_time);
    }

    @Override
    public void bind(ProgramVO data) {
        tvItemTitle.setText(data.getTitle());

    }
}
