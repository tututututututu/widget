package com.hzecool.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import java.math.BigDecimal;

/**
 * Created by wangzhiguo on 2017/6/8
 */
public class BalanceEditText extends android.support.v7.widget.AppCompatEditText {
    public BalanceEditText(Context context) {
        super(context);
    }

    public BalanceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BalanceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 字符串转人民币
     *
     * @param value
     * @return
     */
    public static String str2Rmb(String value) {
        double money = Double.parseDouble(value);
        BigDecimal bigDecimal = BigDecimal.valueOf(money);
        return "¥" + bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * double 类型 转人民币
     *
     * @param value
     * @return
     */
    public static String db2Rmb(double value) {
        try {
            return "¥" + BigDecimal.valueOf(value).setScale(2,BigDecimal.ROUND_HALF_UP);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException();
        }
    }

    public void setText(String text){
        super.setText(str2Rmb(text));
    }

    public void setText(double text){
        super.setText(db2Rmb(text));
    }

    public String getTextValue(){
        return removeRmbStr(super.getText().toString());
    }

    public double getDoubleValue(){
        if (TextUtils.isEmpty(this.getTextValue())){
            return 0.00;
        }
        return Double.parseDouble(this.getTextValue());
    }

    private String removeRmbStr(@NonNull String text) {
        return text.replace("¥", "");
    }


    public void setTextZero(){
        this.setText(0.00);
    }
}
