package com.example.msimple.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.msimple.R
import com.example.msimple.data.vos.SessionVO
import com.example.msimple.view.holders.BaseHolder
import com.example.msimple.view.holders.SessionViewHolder

class SessionAdapter : BaseAdapter<SessionViewHolder, SessionVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SessionViewHolder {

        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.activity_session, viewGroup, false)
        return SessionViewHolder(view)

    }


}
