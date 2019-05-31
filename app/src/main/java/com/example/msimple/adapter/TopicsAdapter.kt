package com.example.msimple.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.msimple.R
import com.example.msimple.data.vos.TopicVO
import com.example.msimple.view.holders.TopicsHolder

class TopicsAdapter : BaseAdapter<TopicsHolder, TopicVO>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TopicsHolder {

        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_view_topics, viewGroup, false)

        return TopicsHolder(view)
    }


}
