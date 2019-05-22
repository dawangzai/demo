package com.wangzai.lovesy.demo2.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

public class CustomerView extends View {
    private VelocityTracker mTracker;

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (mTracker == null) {
            mTracker = VelocityTracker.obtain();
        }
        mTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG111", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("TAG111", "ACTION_MOVE");
                mTracker.computeCurrentVelocity(1000);
                Log.i("TAG111", mTracker.getXVelocity() + "----" + mTracker.getYVelocity());
                break;
            case MotionEvent.ACTION_UP:
                Log.i("TAG111", "ACTION_UP");
                if (mTracker != null) {
                    mTracker.clear();
                    mTracker.recycle();
                }
                break;
            default:
        }

        return true;
    }
}
