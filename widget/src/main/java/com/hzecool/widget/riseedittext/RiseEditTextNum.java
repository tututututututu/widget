package com.hzecool.widget.riseedittext;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hzecool.widget.R;
import com.hzecool.widget.utils.SizeUtils;

/**
 * 仅支持输入数字的自增的edittext
 * Created by song on 2017/7/3.
 */

public class RiseEditTextNum extends LinearLayout {
    private LinearLayout mLl_editext;

    public RiseEditTextNum(Context context) {
        this(context,null);
    }

    public RiseEditTextNum(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RiseEditTextNum(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.edittext_layout, this);
        mLl_editext = (LinearLayout) findViewById(R.id.ll_edittext);
    }

    private String content;

    public void setContent(String content) {
        this.content = content;
        //初始化edittext的数量
        initEditextNum();
    }

    private void initEditextNum() {
        mLl_editext.removeAllViews();
        char[] chars = content.toCharArray();
        for (int i = 0; i < content.length(); i++) {
            EditText editText = new EditText(getContext());
            // MaterialEditText materialEditText = new MaterialEditText(getContext());
            editText.setBackgroundResource(R.drawable.bg_square_voice);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            editText.setPadding(SizeUtils.dp2px(getContext(), 10), 0, SizeUtils.dp2px(getContext(), 10), 0);
            params.topMargin = SizeUtils.dp2px(getContext(), 4);
            params.bottomMargin = SizeUtils.dp2px(getContext(), 4);
            params.leftMargin = SizeUtils.dp2px(getContext(), 10);
            editText.setTextSize(SizeUtils.sp2px(getContext(), 8));
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            //限制输入内容的长度
            //  editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            editText.setGravity(Gravity.CENTER);
            editText.setText(String.valueOf(chars[i]));
            //去除滑动内容弹出复制粘贴
            editText.setCustomSelectionActionModeCallback(mCallback);
            //去除长按复制功能
            editText.setLongClickable(false);
            //默认不全部选中内容
            editText.setSelectAllOnFocus(false);
            //清除焦点
            editText.clearFocus();
            //默认不选中内容
            editText.setSelected(false);
            //不显示光标
            editText.setCursorVisible(false);
            //添加view
            mLl_editext.addView(editText, params);
            editText.setOnClickListener(mPointClickListener);
            /*editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    ((EditText) v).setText(null);
                }
            });*/
        }
    }



    /**
     * 去掉复制粘贴的功能
     */
    private ActionMode.Callback mCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    private OnClickListener mPointClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ((EditText) v).setText(null);
        }
    };

    /**
     * 实现editText的getText()功能
     *
     * @return
     */
    public String getText() {
        String str = "";
        int count = mLl_editext.getChildCount();
        for (int i = 0; i < count; i++) {
            EditText child = (EditText) mLl_editext.getChildAt(i);
            str = str + child.getText();
        }
        return str;
    }

}
