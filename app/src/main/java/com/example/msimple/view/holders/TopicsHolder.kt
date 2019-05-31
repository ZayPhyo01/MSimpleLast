package com.example.msimple.view.holders

import android.view.View
import android.widget.TextView

import com.example.msimple.R
import com.example.msimple.data.vos.TopicVO

class TopicsHolder(itemView: View) : BaseHolder<TopicVO>(itemView) {

    internal var tvTopicsTitle: TextView
    internal var tvTopicsDescription: TextView

    init {

        tvTopicsTitle = itemView.findViewById(R.id.tv_topic_title)
        tvTopicsDescription = itemView.findViewById(R.id.tv_topic_description)


    }


    override fun bind(data: TopicVO) {

        tvTopicsTitle.text = data.topicName
        tvTopicsDescription.text = data.topicDesc

    }
}
