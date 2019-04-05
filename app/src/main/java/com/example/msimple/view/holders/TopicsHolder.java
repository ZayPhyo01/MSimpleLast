package com.example.msimple.view.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.msimple.R;
import com.example.msimple.data.vos.TopicVO;

public class TopicsHolder extends BaseHolder <TopicVO> {

    TextView tvTopicsTitle;
    TextView tvTopicsDescription;

    public TopicsHolder(@NonNull View itemView) {
        super(itemView);

        tvTopicsTitle = itemView.findViewById(R.id.tv_topic_title);
        tvTopicsDescription = itemView.findViewById(R.id.tv_topic_description);


    }


    @Override
    public void bind(TopicVO data) {

        tvTopicsTitle.setText(data.getTopicName());
        tvTopicsDescription.setText(data.getTopicDesc());

    }
}
