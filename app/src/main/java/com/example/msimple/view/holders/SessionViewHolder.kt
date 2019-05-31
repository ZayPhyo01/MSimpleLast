package com.example.msimple.view.holders


import android.view.View
import android.widget.TextView

import com.example.msimple.R
import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.data.vos.SessionVO


class SessionViewHolder(itemView: View) : BaseHolder<SessionVO>(itemView) {


    private var msessionsVO: SessionVO? = null

    internal var i = 1

    override fun bind(data: SessionVO) {

        val tvNumber: TextView
        val tvSessionName: TextView
        val tvAverageLength: TextView
        msessionsVO = data
        val totalSeconds: Long
        val minutes: Long
        val seconds: Long

        tvNumber = itemView.findViewById(R.id.tv_no)
        tvSessionName = itemView.findViewById(R.id.tv_session_name)
        tvAverageLength = itemView.findViewById(R.id.tv_average_length)
        val time = msessionsVO!!.time
        tvAverageLength.text = time
        tvNumber.text = (adapterPosition + 1).toString() + ""
        i++

        tvSessionName.text = msessionsVO!!.title


    }


}
