package com.example.msimple.view.holders

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

import com.example.msimple.delegate.OnClickItem
import com.example.msimple.R
import com.example.msimple.adapter.ProgramAdapter
import com.example.msimple.data.vos.CategoryVO

class CategoryHolder(itemView: View, internal var onClickItem: OnClickItem) : BaseHolder<CategoryVO>(itemView) {

    internal var recyclerView: RecyclerView
    internal var programAdapter: ProgramAdapter

    init {
        recyclerView = itemView.findViewById(R.id.rv_category_program)
        programAdapter = ProgramAdapter(onClickItem)
        recyclerView.adapter = programAdapter
        recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

    }


    override fun bind(data: CategoryVO) {
        Log.d("CategoryHolderTitle", data.title)
        programAdapter.setNewData(data.programs!!)

    }


}
