package com.hzecool.widget.xRecyclerView;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzecool.widget.R;
import com.hzecool.widget.utils.SizeUtils;


/**
 * Created by tutu on 2017/1/12.
 */

public class RecyclerViewEmptyView extends RelativeLayout {
	private ImageView iv;
	private TextView tv;
	/**
	 * textview 距离 imageview 的距离
	 */
	private int tvTopMargin = 0;

	private LayoutParams params;


	public RecyclerViewEmptyView(Context context) {
		this(context, null);
		initView();
	}

	public RecyclerViewEmptyView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RecyclerViewEmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}


	private void initView() {
		params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		iv = new ImageView(getContext());
		tv = new TextView(getContext());

		params.addRule(CENTER_IN_PARENT, TRUE);
		iv.setLayoutParams(params);
		iv.setImageResource(R.mipmap.empty);

		params.addRule(CENTER_HORIZONTAL, TRUE);
		params.addRule(BELOW, iv.getId());
		params.topMargin = SizeUtils.dp2px(getContext(),10);
		tv.setLayoutParams(params);
		tv.setText(R.string.empty_data);


		this.addView(iv);
		this.addView(tv);
	}


	public RecyclerViewEmptyView setText(String text) {
		tv.setText(text);
		return this;
	}

	public RecyclerViewEmptyView setTextColor(@ColorInt int color) {
		tv.setTextColor(color);
		return this;
	}

	public RecyclerViewEmptyView setTextSize(@DimenRes int size) {
		tv.setTextSize(size);
		return this;
	}

	public RecyclerViewEmptyView setTvIvMargin(int dp) {
		params.topMargin = SizeUtils.dp2px(getContext(),dp);
		tv.setLayoutParams(params);
		return this;
	}

	public RecyclerViewEmptyView setImageSrc(int resId) {
		iv.setImageResource(resId);
		return this;
	}


}
