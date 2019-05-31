package com.example.msimple.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.msimple.delegate.OnClickItem
import com.example.msimple.R
import com.example.msimple.data.vos.ProgramVO
import com.example.msimple.view.holders.ProgramHolder

class ProgramAdapter(internal var onClickItem: OnClickItem) : BaseAdapter<ProgramHolder, ProgramVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProgramHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_view_program, viewGroup, false)
        return ProgramHolder(view, onClickItem)
    }
}
