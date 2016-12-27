package com.example.leijianmin.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by Qiu on 2016/11/2.
 */

public class LeftArrowRoundLayout extends LinearLayout {

    Paint mPaint;

    float strokeWidth;
    int strokeColor;

    public LeftArrowRoundLayout(Context context) {
        super(context);
        init(context, null);
    }

    public LeftArrowRoundLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LeftArrowRoundLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        strokeWidth = 5;
        strokeColor = Color.parseColor("#EEEEEE");

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(strokeColor);
        mPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Path path = new Path();

        Rect bounds = canvas.getClipBounds();

        int radius = 40;
        int arrowTop = 200;
        int arrowWidth = 40;
        int arrowHeight = 20;

        int w = bounds.width();
        int h = bounds.height();

        //从箭头顶点开始
        path.moveTo(0, arrowTop);
        path.lineTo(arrowWidth, arrowTop - arrowHeight);

        // 画第一个圆角
        path.lineTo(arrowWidth, radius);
        RectF rectF = new RectF(arrowWidth + 0, 0, arrowWidth + radius * 2, radius * 2);
        path.arcTo(rectF, 180, 90, false);
        path.lineTo(arrowWidth + radius, 0);

        // 画第二个圆角
        path.lineTo(w - radius, 0);
        rectF.set(w - 2 * radius, 0, w, 2 * radius);
        path.arcTo(rectF, 270, 90, false);
        path.lineTo(w, radius);

        // 画第三个圆角
        path.lineTo(w, h - radius);
        rectF.set(w - 2 * radius, h - 2 * radius, w, h);
        path.arcTo(rectF, 0, 90, false);
        path.lineTo(w - radius, h);

        // 画第四个圆角
        path.lineTo(arrowWidth + radius, h);
        rectF.set(arrowWidth, h - 2 * radius, arrowWidth + 2 * radius, h);
        path.arcTo(rectF, 90, 90, false);
        path.lineTo(arrowWidth, h - radius);


        path.lineTo(arrowWidth, arrowTop + arrowHeight);
        path.lineTo(0, arrowTop);

        canvas.clipPath(path);

        super.dispatchDraw(canvas);

        if (strokeWidth > 0) {
            canvas.drawPath(path, mPaint);
        }
    }

}
