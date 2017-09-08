package com.hzecool.widget.popwindowlist;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzecool.widget.R;

import java.util.List;

/**
 * Created by tutu on 2017/4/17.
 */

public class PopAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public PopAdapter(int resId, List<String> data) {

        super(resId, data);


    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
    }
}
