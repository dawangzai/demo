package com.wangzai.lovesy.demo2.scrolldemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Scroller;
import android.widget.TextView;

public class ScrollableTextView extends android.support.v7.widget.AppCompatTextView {

//    private Scroller mScroller;

    private int lastX;
    private int lastY;

    public ScrollableTextView(Context context) {
        this(context, null);
    }

    public ScrollableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

//        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = (int) (rawX - lastX);
                int deltaY = (int) (rawY - lastY);
//                ObjectAnimator
//                        .ofFloat(this, "translationX", rawX)
//                .start();
//                ObjectAnimator
//                        .ofFloat(this, "translationY", rawY)
//                        .start();
//                animate().translationX(200);
//                animate().translationY(200);
                setX(rawX);
                setY(rawY);
                break;
        }
        lastX = rawX;
        lastY = rawY;
        return true;
    }

    //    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        switch (event.getActionMasked()) {
//            case MotionEvent.ACTION_DOWN: {
//                if (!mScroller.isFinished())
//                    return false;
//                return true;
//            }
//            case MotionEvent.ACTION_MOVE: {
//                int x = (int) event.getX();
//                int y = (int) event.getY();
//                //Step 2:调用startScroll完成滚动数据的初始化以及刷新界面
//                smoothScrollTo(x, y);
//                return true;
//            }
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                return true;
//        }
//
//        return true;
//
//    }
//
//    private void smoothScrollTo(int destX, int destY) {
//        int dx = destX - Math.abs(getScrollX());
//        int dy = destY - Math.abs(getScrollY());
//        mScroller.startScroll(getScrollX(), getScrollY(), -dx, -dy, 1000);
//        invalidate();
//    }
//
//    @Override
//    public void computeScroll() {
//        if (mScroller != null && mScroller.computeScrollOffset()) {
//            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
//            postInvalidate();
//        }
//    }
}
