package com.qinxiaoguai.library;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by 秦小怪 on 2017/8/1.
 */
public class StringUtils {
    /**
     * 获取非空的text
     */
    public static String obtainNoNullText(String content) {
        return obtainNoNullText(content, "");
    }

    /**
     * 获取非空的text，null或者empty时候可以设置默认值
     * 对content, defaultContent都进行判空操作
     */
    public static String obtainNoNullText(String content, @NonNull String defaultContent) {
        return !TextUtils.isEmpty(content) ? content
            : (!TextUtils.isEmpty(defaultContent) ? defaultContent : "");
    }
}
