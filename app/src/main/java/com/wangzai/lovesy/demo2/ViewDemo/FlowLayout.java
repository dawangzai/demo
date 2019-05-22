package com.wangzai.lovesy.demo2.ViewDemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    private ArrayList<View> mRowList = new ArrayList<>();
    private ArrayList<ArrayList<View>> mViewList = new ArrayList<>();
    private boolean isReLine = false; // 已经换过行了

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (mViewList != null) {
            mViewList.clear();
        }

        // 最终 ViewGroup 的宽高
        int width = 0;
        int height = 0;

        // 当前行的宽高
        int currentWidth = 0;
        int currentHeight = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams childViewLayoutParams = (MarginLayoutParams) childView.getLayoutParams();
            int childWidth = childView.getMeasuredWidth() +
                    childViewLayoutParams.rightMargin +
                    childViewLayoutParams.leftMargin;
            int childHeight = childView.getMeasuredHeight() +
                    childViewLayoutParams.topMargin +
                    childViewLayoutParams.bottomMargin;

            if (currentWidth + childWidth > widthSize) { // 需要换行了
                isReLine = true;
                width = Math.max(currentWidth, childWidth);
                height = currentHeight + childHeight;

                currentWidth = childWidth; // 设置 currentWidth 为当前行的宽度
                currentHeight = height;

                ArrayList<View> currentViews = new ArrayList<>(mRowList);
                mViewList.add(currentViews);
                mRowList.clear();
                mRowList.add(childView);
            } else {
                currentWidth += childWidth;
                currentHeight = Math.max(currentHeight, childHeight);
                if (!isReLine) {
                    height = currentHeight;
                }
                mRowList.add(childView);
            }
            if (i == childCount - 1) { // 最后一个 childView
                width = Math.max(currentWidth, width);
                @SuppressLint("DrawAllocation") ArrayList<View> currentViews = new ArrayList<>(mRowList);
                mViewList.add(currentViews);
                isReLine = true;
                mRowList.clear();
            }
        }

//        width = widthMode == MeasureSpec.EXACTLY ? widthSize : width;
//        height = heightMode == MeasureSpec.EXACTLY ? heightSize : height;

        setMeasuredDimension(widthSize, height);
        isReLine = false;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left = getPaddingLeft();
        int top = getPaddingTop();

        int rowSize = mViewList.size();
        for (int i = 0; i < rowSize; i++) {
            ArrayList<View> views = mViewList.get(i);
            int size = views.size();
            for (int j = 0; j < size; j++) {
                View childView = views.get(j);
                MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
                int childWidth = childView.getMeasuredWidth();
                int childHeight = childView.getMeasuredHeight();
                Log.i("TAG111", "left=" + left + "---" + "top=" + top + "---" + "right=" + left + childWidth + "---" + "bottom=" + top + childHeight);
                childView.layout(left + lp.leftMargin, top + lp.topMargin, left + childWidth, top + childHeight);
                left += (childWidth + lp.rightMargin);
                if (j == size - 1) {
                    top += (childHeight + lp.bottomMargin);
                }
            }
            left = getPaddingLeft();
        }
    }
}
