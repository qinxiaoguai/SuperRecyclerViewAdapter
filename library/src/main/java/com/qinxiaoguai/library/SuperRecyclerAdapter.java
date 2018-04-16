package com.qinxiaoguai.library;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by 秦小怪 on 2017/8/10.
 */
public abstract class SuperRecyclerAdapter<T> extends RecyclerView.Adapter<SuperRecyclerHolder> {
    private Context mCtx;
    private List<T> mValueList;

    public SuperRecyclerAdapter(Context mCtx, List<T> mValueList) {
        this.mCtx = mCtx;
        this.mValueList = mValueList;
    }

    @Override public SuperRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mCtx).inflate(viewType, parent, false);
        return SuperRecyclerHolder.createViewHolder(mCtx, itemView);
    }

    @Override public void onBindViewHolder(SuperRecyclerHolder holder, int position) {
        convert(holder, getValue(position), getItemViewType(position), position);
    }

    @Override public int getItemCount() {
        return mValueList.size();
    }

    @Override public int getItemViewType(int position) {
        return getLayoutAsViewType(getValue(position), position);
    }

    public List<T> getValueList() {
        return mValueList;
    }

    public T getValue(int position) {
        return getValueList().get(position);
    }

    public abstract void convert(SuperRecyclerHolder holder, T t, int layoutType, int position);

    @LayoutRes public abstract int getLayoutAsViewType(T t, int position);
}
