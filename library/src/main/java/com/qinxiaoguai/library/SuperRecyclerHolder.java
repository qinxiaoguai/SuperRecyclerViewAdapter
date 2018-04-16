package com.qinxiaoguai.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 通用的RecyclerView的ViewHolder
 * 采用链式调用
 * <p>
 * Created by 秦小怪 on 2017/8/1.
 */
public class SuperRecyclerHolder extends RecyclerView.ViewHolder {
    private Context mCtx;
    private SparseArray<View> mViewArray = new SparseArray<>();

    /**
     * 创建ViewHolder实例
     */
    public static SuperRecyclerHolder createViewHolder(Context ctx, View itemView) {
        return new SuperRecyclerHolder(ctx, itemView);
    }

    /**
     * 方法用private，私有化构造方法，限制只允许使用SuperRecyclerHolder.createViewHolder()来创建实例
     */
    private SuperRecyclerHolder(Context ctx, View itemView) {
        super(itemView);
        mCtx = ctx;
    }

    public Context getContext() {
        return mCtx;
    }

    public View getItemView() {
        return itemView;
    }

    public View getViewById(@IdRes int viewId) {
        return retrieveView(viewId);
    }

    /**
     * 整个item的点击事件
     */
    public SuperRecyclerHolder setOnItemClickListenner(@Nullable View.OnClickListener listener) {
        getItemView().setOnClickListener(listener);
        return this;
    }

    /**
     * 整个item的点击事件，可以根据条件来禁止某些符合条件的点击事件
     * <p>
     * 这个需求是在是开发的时候发现的，才加上去的，能不能点击根据后端的返回来确定的，可以使用该方法
     * 比如：列表显示了很多好友的用户名，在线的可以点击，不在线的不能点击，
     */
    public SuperRecyclerHolder setOnItemClickListenner(boolean isListener,
        @Nullable View.OnClickListener listener) {
        getItemView().setOnClickListener(isListener ? listener : null);
        return this;
    }

    /**
     * 整个item的长按事件
     */
    public SuperRecyclerHolder setOnItemLongClickListener(
        @Nullable View.OnLongClickListener listener) {
        getItemView().setOnLongClickListener(listener);
        return this;
    }

    public SuperRecyclerHolder setOnItemLongClickListener(boolean isListener,
        @Nullable View.OnLongClickListener listener) {
        getItemView().setOnLongClickListener(isListener ? listener : null);
        return this;
    }

    /**
     * 整个item的触摸事件
     */
    public SuperRecyclerHolder setOnItemTouchListener(@NonNull View.OnTouchListener listener) {
        getItemView().setOnTouchListener(listener);
        return this;
    }

    public SuperRecyclerHolder setOnItemTouchListener(boolean isListener,
        @NonNull View.OnTouchListener listener) {
        getItemView().setOnTouchListener(isListener ? listener : null);
        return this;
    }

    public SuperRecyclerHolder setOnClickListenner(@IdRes int viewId,
        @Nullable View.OnClickListener listener) {
        retrieveView(viewId).setOnClickListener(listener);
        return this;
    }

    public SuperRecyclerHolder setOnLongClickListener(@IdRes int viewId,
        @Nullable View.OnLongClickListener listener) {
        retrieveView(viewId).setOnLongClickListener(listener);
        return this;
    }

    public SuperRecyclerHolder setOnTouchListener(@IdRes int viewId,
        @NonNull View.OnTouchListener listener) {
        retrieveView(viewId).setOnTouchListener(listener);
        return this;
    }

    public SuperRecyclerHolder setOnFocusChangeListener(@IdRes int viewId,
        @NonNull View.OnFocusChangeListener listener) {
        retrieveView(viewId).setOnFocusChangeListener(listener);
        return this;
    }

    public SuperRecyclerHolder setOnFocusChangeListener(
        @NonNull View.OnFocusChangeListener listener) {
        getItemView().setOnFocusChangeListener(listener);
        return this;
    }

    public SuperRecyclerHolder setAlpha(@IdRes int viewId,
        @FloatRange(from = 0.0, to = 1.0) float alpha) {
        retrieveView(viewId).setAlpha(alpha);
        return this;
    }

    public SuperRecyclerHolder setBackgroundResource(@IdRes int viewId, @DrawableRes int resId) {
        retrieveView(viewId).setBackgroundResource(resId);
        return this;
    }

    public SuperRecyclerHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        retrieveView(viewId).setBackgroundColor(color);
        return this;
    }

    public SuperRecyclerHolder setClickable(@IdRes int viewId, boolean clickable) {
        retrieveView(viewId).setClickable(clickable);
        return this;
    }

    public SuperRecyclerHolder setEnabled(@IdRes int viewId, boolean enabled) {
        retrieveView(viewId).setEnabled(enabled);
        return this;
    }

    public SuperRecyclerHolder setFocusable(@IdRes int viewId, boolean focusable) {
        retrieveView(viewId).setFocusable(focusable);
        return this;
    }

    public SuperRecyclerHolder setFocusableInTouchMode(@IdRes int viewId,
        boolean focusableInTouchMode) {
        retrieveView(viewId).setFocusableInTouchMode(focusableInTouchMode);
        return this;
    }

    public SuperRecyclerHolder setTag(@IdRes int viewId, final Object tag) {
        retrieveView(viewId).setTag(tag);
        return this;
    }

    public SuperRecyclerHolder setTag(@IdRes int viewId, int key, final Object tag) {
        retrieveView(viewId).setTag(key, tag);
        return this;
    }

    public SuperRecyclerHolder setVisibility(@IdRes int viewId, int visibility) {
        retrieveView(viewId).setVisibility(visibility);
        return this;
    }

    /**
     * 传入是否显示，true显示，false Gone掉
     */
    public SuperRecyclerHolder setVisibility(@IdRes int viewId, boolean isVisibility) {
        retrieveView(viewId).setVisibility(isVisibility ? View.VISIBLE : View.GONE);
        return this;
    }

    public SuperRecyclerHolder setLongClickable(@IdRes int viewId, boolean longClickable) {
        retrieveView(viewId).setLongClickable(longClickable);
        return this;
    }

    /**
     * AppCompatCheckBox, AppCompatCheckedTextView, AppCompatRadioButton,CheckBox, CheckedTextView,
     * CompoundButton, RadioButton, Switch, SwitchCompat, ToggleButton都可以使用
     *
     * 最常使用的是CheckBox，RadioButton,SwitchCompat设置check
     */
    public SuperRecyclerHolder setChecked(@IdRes int viewId, boolean checked) {
        Checkable iCheckable = retrieveView(viewId);
        iCheckable.setChecked(checked);
        return this;
    }

    /**
     * CheckBox, RadioButton, Switch, SwitchCompat, ToggleButton
     * ,AppCompatCheckBox, AppCompatRadioButton等都可以使用
     * 凡是继承CompoundButton的都可以使用
     *
     * 最常使用的是CheckBox，RadioButton,SwitchCompat设置监听
     */
    public SuperRecyclerHolder setOnCheckedChangeListener(@IdRes int viewId,
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        CompoundButton checkBox = retrieveView(viewId);
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    /**
     * 该方法使用频率非常高，而且大多时候，是从网络加载的数据，所有可能会出现空指针异常
     * StringUtils.obtainNoNullText转换以后，确保不会出现空指针异常，网络请求的数据不需要再次进行判空操作
     *
     * 省去每次都要TextUtils.isEmpty操作，不用关心数据是否为空
     */
    public SuperRecyclerHolder setText(@IdRes int viewId, String content) {
        return setText(viewId, content, "");
    }

    /**
     * 该方法使用频率非常高，而且大多时候，是从网络加载的数据，所有可能会出现空指针异常
     * StringUtils.obtainNoNullText转换以后，确保不会出现空指针异常，网络请求的数据不需要再次进行判空操作
     *
     * 省去每次都要TextUtils.isEmpty操作，不用关心数据是否为空,可设置默认值
     */
    public SuperRecyclerHolder setText(@IdRes int viewId, String content, String defaultContent) {
        TextView textView = retrieveView(viewId);
        textView.setText(StringUtils.obtainNoNullText(content, defaultContent));
        return this;
    }

    public SuperRecyclerHolder setText(@IdRes int viewId, @StringRes int resId) {
        TextView textView = retrieveView(viewId);
        textView.setText(resId);
        return this;
    }

    public SuperRecyclerHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        TextView textView = retrieveView(viewId);
        textView.setTextColor(color);
        return this;
    }

    /**
     * 设置颜色，直接传入colorRes，在方法内部去转换
     */
    public SuperRecyclerHolder setTextColorResource(@IdRes int viewId, @ColorRes int colorRes) {
        TextView textView = retrieveView(viewId);
        textView.setTextColor(ContextCompat.getColor(getContext(), colorRes));
        return this;
    }

    public SuperRecyclerHolder setTextSize(@IdRes int viewId, float size) {
        TextView textView = retrieveView(viewId);
        textView.setTextSize(size);
        return this;
    }

    public SuperRecyclerHolder setTextSize(@IdRes int viewId, int unit, float size) {
        TextView textView = retrieveView(viewId);
        textView.setTextSize(unit, size);
        return this;
    }

    public SuperRecyclerHolder setMaxLines(@IdRes int viewId, int maxLines) {
        TextView textView = retrieveView(viewId);
        textView.setMaxLines(maxLines);
        return this;
    }

    public SuperRecyclerHolder setInputType(@IdRes int viewId, int type) {
        TextView textView = retrieveView(viewId);
        textView.setInputType(type);
        return this;
    }

    public SuperRecyclerHolder setHint(@IdRes int viewId, @StringRes int resId) {
        TextView textView = retrieveView(viewId);
        textView.setHint(resId);
        return this;
    }

    public SuperRecyclerHolder setHint(@IdRes int viewId, String hint) {
        TextView textView = retrieveView(viewId);
        textView.setHint(hint);
        return this;
    }

    public SuperRecyclerHolder addTextChangedListener(@IdRes int viewId, TextWatcher watcher) {
        TextView textView = retrieveView(viewId);
        textView.addTextChangedListener(watcher);
        return this;
    }

    public SuperRecyclerHolder setImageBitmap(@IdRes int viewId, Bitmap bitmap) {
        ImageView imageView = retrieveView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public SuperRecyclerHolder setImageResource(@IdRes int viewId, @DrawableRes int resId) {
        ImageView imageView = retrieveView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    /**
     * 保留方法,自己根据项目进行修改
     * 也可以添加设置圆角的图片url等等，根据需求添加
     */
    public SuperRecyclerHolder setImageUrl(@IdRes int viewId, String url) {
        if (TextUtils.isEmpty(url)) {
            return this;
        }
        ImageView imageView = retrieveView(viewId);
        //TODO 请根据自己项目使用的图片加载框架来加载
        return this;
    }

    public SuperRecyclerHolder setProgress(@IdRes int viewId, int progress) {
        ProgressBar progressBar = retrieveView(viewId);
        progressBar.setProgress(progress);
        return this;
    }

    public SuperRecyclerHolder setProgressMax(@IdRes int viewId, int max) {
        ProgressBar progressBar = retrieveView(viewId);
        progressBar.setMax(max);
        return this;
    }

    /**
     * 通过viewId从缓存中获取View
     * <p>
     * 对View进行缓存处理
     */
    private <T extends View> T retrieveView(@IdRes int viewId) {
        View retrieveView = mViewArray.get(viewId);
        if (retrieveView == null) {
            retrieveView = getItemView().findViewById(viewId);
            mViewArray.put(viewId, retrieveView);
        }
        return (T) retrieveView;
    }
}
