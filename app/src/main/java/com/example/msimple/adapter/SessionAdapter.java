package com.example.msimple.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.msimple.R;
import com.example.msimple.data.vos.SessionVO;
import com.example.msimple.view.holders.BaseHolder;
import com.example.msimple.view.holders.SessionViewHolder;

public class SessionAdapter extends BaseAdapter<SessionViewHolder, SessionVO> {

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.activity_session,viewGroup,false);
        return new SessionViewHolder(view);

    }


}
