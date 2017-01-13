package com.example.leijianmin.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by leijianmin on 2016/12/27.
 */

public class TestLayout extends FrameLayout {
    public TestLayout(Context context) {
        super(context);
    }

    public TestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int mLastX;
    int mLastY;
    int mLastXIntercept;
    int mLastYIntercept;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                intercepted = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                if (Math.abs(deltaX) < Math.abs(deltaY)) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercepted = false;

                mLastXIntercept = x;
                mLastYIntercept = y;
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;


        return intercepted;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TestLayout", "onTouchEvent");
        return true;
    }
}
