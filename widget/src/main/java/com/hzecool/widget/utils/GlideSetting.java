package com.hzecool.widget.utils;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by 47066 on 2017/9/7.
 */

public class GlideSetting {
    public static RequestOptions getGlideSetting() {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                //.placeholder(R.drawable.placeholder)
                //.error(R.drawable.error)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        return options;
    }

}
