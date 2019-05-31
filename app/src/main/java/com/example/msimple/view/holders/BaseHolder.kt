package com.example.msimple.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View

import java.util.ArrayList

abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun bind(data: T)


    override fun onClick(v: View) {

    }
}
