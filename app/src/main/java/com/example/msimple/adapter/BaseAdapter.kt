package com.example.msimple.adapter

import android.support.v7.widget.RecyclerView

import com.example.msimple.view.holders.BaseHolder

import java.util.ArrayList

abstract class BaseAdapter<T : BaseHolder<W>, W> : RecyclerView.Adapter<T>() {

    private var mData: MutableList<W>? = null

    val items: List<W>
        get() = if (mData == null) ArrayList() else mData

    init {
        mData = ArrayList()
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bind(mData!![position])

    }

    fun setNewData(newData: MutableList<W>) {
        mData = newData
        notifyDataSetChanged()

    }

    fun appendNewData(newData: List<W>) {
        mData!!.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData!!.size - 1) mData!![position] else null

    }

    fun removeData(data: W) {
        mData!!.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: W) {
        mData!!.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mData = ArrayList()
        notifyDataSetChanged()
    }

}
