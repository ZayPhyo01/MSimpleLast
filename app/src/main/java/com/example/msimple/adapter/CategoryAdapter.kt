package com.example.msimple.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.msimple.delegate.OnClickItem
import com.example.msimple.R
import com.example.msimple.data.vos.CategoryVO
import com.example.msimple.view.holders.CategoryHolder

class CategoryAdapter(internal var clickItem1: OnClickItem) : BaseAdapter<CategoryHolder, CategoryVO>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CategoryHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_view_category, viewGroup, false)
        return CategoryHolder(view, clickItem1)
    }
}
