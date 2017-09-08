package com.hzecool.widget.puzzle;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by dd on 16/1/13.
 */
public class SelectItem extends RelativeLayout {


    private ImageView mImageView;

    public SelectItem(Context context) {
        super(context);
        mImageView = new ImageView(context);
        mImageView.setAdjustViewBounds(true);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LayoutParams mImageViewRLP = new LayoutParams(DensityUtil.dip2px(context, 60), DensityUtil.dip2px(context, 60));
        mImageViewRLP.addRule(RelativeLayout.CENTER_IN_PARENT);
        mImageViewRLP.setMargins(0, DensityUtil.dip2px(context, 30), DensityUtil.dip2px(context, 20), 0);
        addView(mImageView, mImageViewRLP);
    }

    public ImageView getmImageView() {
        return mImageView;
    }
}
