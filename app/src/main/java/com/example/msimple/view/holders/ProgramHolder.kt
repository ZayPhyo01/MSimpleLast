package com.example.msimple.view.holders

import android.view.View
import android.widget.TextView

import com.example.msimple.delegate.OnClickItem
import com.example.msimple.R
import com.example.msimple.data.vos.ProgramVO

class ProgramHolder(itemView: View, internal var onClickItem: OnClickItem) : BaseHolder<ProgramVO>(itemView) {

    internal var tvItemTitle: TextView
    internal var programVO: ProgramVO


    init {

        tvItemTitle = itemView.findViewById(R.id.tv_item_time)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        onClickItem.onTap(programVO)


    }

    override fun bind(data: ProgramVO) {
        programVO = data
        tvItemTitle.text = data.title

    }
}
