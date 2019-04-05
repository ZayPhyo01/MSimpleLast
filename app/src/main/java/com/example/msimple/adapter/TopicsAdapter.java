package com.example.msimple.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msimple.R;
import com.example.msimple.data.vos.TopicVO;
import com.example.msimple.view.holders.TopicsHolder;

public class TopicsAdapter extends BaseAdapter<TopicsHolder, TopicVO> {
    @NonNull
    @Override
    public TopicsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_view_topics, viewGroup, false);

        return new TopicsHolder(view);
    }



}
