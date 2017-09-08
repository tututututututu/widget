package com.hzecool.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import java.math.BigDecimal;

/**
 * Created by wangzhiguo on 2017/6/8
 */
public class BalanceTextView extends android.support.v7.widget.AppCompatTextView {

    private double showText;
    public BalanceTextView(Context context) {
        super(context);
    }

    public BalanceTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BalanceTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
            return "¥" + new BigDecimal(value).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        } catch (NumberFormatException ex) {
            throw new NumberFormatException();
        }
    }

    public void setText(@NonNull String text){
        super.setText(str2Rmb(text));
    }

    public String getText(){
        return removeRmbStr(super.getText().toString());
    }

    public void setText(@NonNull double text){
        super.setText(db2Rmb(text));
    }

    public double getDoubleValue(){
        return Double.parseDouble(this.getText());
    }

    private String removeRmbStr(@NonNull  String text) {
        return text.replace("¥", "");
    }


    public double getShowText(){
        if (isLessZero){
            return new BigDecimal(removeRmbStr(super.getText().toString())).multiply(new BigDecimal(-1)).floatValue();
        }else {
            return new BigDecimal(removeRmbStr(super.getText().toString())).multiply(new BigDecimal(1)).floatValue();
        }
    }

    private boolean isLessZero = false;

    public void setShowText(double text){
        if (text <= 0){
            isLessZero = true;
        }else if (text > 0){
            isLessZero = false;
        }
        setText(Math.abs(text));
    }

}
