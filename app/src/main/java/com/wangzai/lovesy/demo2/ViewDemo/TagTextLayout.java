package com.wangzai.lovesy.demo2.ViewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TagTextLayout extends FrameLayout {

    private int tagWidth;
    private String content = "大富科技圣诞节福利时代峻峰发牢骚的解放军是的龙卷风禄口街道九分裤世纪东方就离开房间爱空间发";

    public TagTextLayout(Context context) {
        super(context);
    }

    public TagTextLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagTextLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("TAG111", "onLayout");
        View childView = getChildAt(0);
        int tagWidth = childView.getMeasuredWidth();
        TextView tv = (TextView) getChildAt(1);
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new LeadingMarginSpan.Standard(tagWidth + 30, 0), 0, ssb.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tv.setText(ssb);
    }

}
