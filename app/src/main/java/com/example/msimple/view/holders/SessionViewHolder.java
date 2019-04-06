package com.example.msimple.view.holders;


import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.msimple.R;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.SessionVO;


public class SessionViewHolder extends BaseHolder<SessionVO> {


    private SessionVO msessionsVO;

    int i=1;
    public SessionViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(SessionVO data) {

        TextView tvNumber, tvSessionName, tvAverageLength;
        msessionsVO = data;
        long totalSeconds,minutes,seconds;

        tvNumber = itemView.findViewById(R.id.tv_no);
        tvSessionName = itemView.findViewById(R.id.tv_session_name);
        tvAverageLength = itemView.findViewById(R.id.tv_average_length);
        String time = msessionsVO.getTime();
        tvAverageLength.setText(time);
        tvNumber.setText((getAdapterPosition()+1)+"");
        i++;

        tvSessionName.setText(msessionsVO.getTitle());





    }



}
