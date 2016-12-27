package com.example.leijianmin.myapplication.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by leijianmin on 2016/12/8.
 */

public class AlphaButton extends Button {
    private final static float DEFAULT_DEST_ALPHA = 0.6f;
    public AlphaButton(Context context) {
        super(context);
    }

    public AlphaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlphaButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setAlpha(DEFAULT_DEST_ALPHA);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setAlpha(1f);
                break;
        }

        return super.onTouchEvent(event);
    }
}
