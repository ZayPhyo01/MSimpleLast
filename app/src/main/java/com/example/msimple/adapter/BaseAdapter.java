package com.example.msimple.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.msimple.view.holders.BaseHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends BaseHolder<W>,W> extends RecyclerView.Adapter<T> {

    private List<W> mData;

    public BaseAdapter() {
        mData = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        holder.bind(mData.get(position));

    }

    public void setNewData(List<W> newData) {
        mData = newData;
        notifyDataSetChanged();

    }

    public void appendNewData(List<W> newData) {
        mData.addAll(newData);
        notifyDataSetChanged();
    }

    public W getItemAt(int position) {
        if (position < mData.size() - 1)
            return mData.get(position);

        return null;
    }

    public List<W> getItems() {
        if (mData == null)
            return new ArrayList<>();

        return mData;
    }

    public void removeData(W data) {
        mData.remove(data);
        notifyDataSetChanged();
    }

    public void addNewData(W data) {
        mData.add(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData = new ArrayList<>();
        notifyDataSetChanged();
    }

}
