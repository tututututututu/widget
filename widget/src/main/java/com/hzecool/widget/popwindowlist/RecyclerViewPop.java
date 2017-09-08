package com.hzecool.widget.popwindowlist;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hzecool.widget.R;
import com.hzecool.widget.RecycleViewDivider;
import com.hzecool.widget.utils.SizeUtils;

import java.util.List;

/**
 * Created by tutu on 2017/4/17.
 */

public class RecyclerViewPop {

    private PopupWindow popupWindow;
    private List<String> datas;
    private View target;
    private View content;
    private RecyclerView recyclerView;
    private PopAdapter popAdapter;
    private Context context;
    private int itemViewResId = -1;

    public void setItemView(int resId) {
        itemViewResId = resId;
    }


    public RecyclerViewPop(List<String> datas, View target, Context context, BaseQuickAdapter.OnItemClickListener onItemClickListener) {
        this.datas = datas;
        this.target = target;
        this.context = context;

        content = LayoutInflater.from(context).inflate(R.layout.recyclerview_pop, null);

        recyclerView = (RecyclerView) content.findViewById(R.id.rv);

        if (itemViewResId == -1) {
            popAdapter = new PopAdapter(R.layout.rv_pop_item, datas);
        } else {
            popAdapter = new PopAdapter(itemViewResId, datas);
        }

        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(context, LinearLayout.HORIZONTAL, SizeUtils.dp2px(context,0.5),context.getResources().getColor(R.color.white));
        recycleViewDivider.setMarginLeft(SizeUtils.dp2px(context,7));
        recycleViewDivider.setMarginRight(SizeUtils.dp2px(context,7));
        recyclerView.addItemDecoration(recycleViewDivider);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(popAdapter);

        popupWindow = new PopupWindow(content,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popAdapter.setOnItemClickListener(onItemClickListener);
    }


    public void show() {
        popupWindow.showAsDropDown(target);
    }

    public void dissmiss() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

}
