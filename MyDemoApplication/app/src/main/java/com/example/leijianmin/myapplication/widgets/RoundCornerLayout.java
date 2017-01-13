package com.example.leijianmin.myapplication.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Created by Qiu on 2016/10/21.
 */

public class RoundCornerLayout extends FrameLayout {

    Paint mPaint;

    float radius = 20;
    float strokeWidth = 10;
    int strokeColor = Color.BLACK;
    int backgroundColor = Color.TRANSPARENT;

    public RoundCornerLayout(Context context) {
        super(context);
        init(context, null);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public void setBorderColor(int color) {
        strokeColor = color;
        invalidate();
    }

    public void setBorderWidth(float width) {
        strokeWidth = width;
        invalidate();
    }

    public void setBorderBackgroundColor(int color) {
        backgroundColor = color;
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Path clipPath = new Path();
        int w = this.getWidth();
        int h = this.getHeight();
        try {
            clipPath.addRoundRect(new RectF(0, 0, w, h), radius, radius, Path.Direction.CW);
            canvas.clipPath(clipPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(backgroundColor);
        canvas.drawRoundRect(new RectF(0, 0, w, h), radius, radius, mPaint);

        if (strokeWidth > 0) {
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(strokeColor);
            mPaint.setStrokeWidth(strokeWidth);
            canvas.drawRoundRect(new RectF(0, 0, w, h), radius, radius, mPaint);
        }

        super.dispatchDraw(canvas);
    }

}
