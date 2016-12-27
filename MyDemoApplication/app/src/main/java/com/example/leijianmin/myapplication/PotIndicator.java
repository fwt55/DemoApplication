package com.example.leijianmin.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by leijianmin on 2016/10/26.
 */

public class PotIndicator extends FrameLayout {

    private final static int DOT_SIZE = dpToPx(6);

    private int mCurrent;
    private int mDividerSize = DOT_SIZE;
    private boolean mInitail;

    public PotIndicator(Context context) {
        this(context, null);
    }

    public PotIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setUp(int size) {
        setUp(size, 0);
    }

    public void setUp(int size, int current) {
        mCurrent = current;
        removeAllViews();
        for (int i = 0; i < size; i++) {
            Dot dot = new Dot(getContext());
            if (i == mCurrent) {
                dot.setCurrent(true);
            }
            addView(dot);
        }

        mInitail = true;
    }

    public void setCurrIndex(int current) {
        mCurrent = current;
        for (int i = 0; i < getChildCount(); i++) {
            Dot dot = (Dot) getChildAt(i);
            dot.setCurrent(i == current);
            dot.invalidate();
        }
        requestLayout();
    }

    public int getCurrIndex() {
        return mCurrent;
    }

    public boolean isInitial() {
        return mInitail;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newWidthSpec = measureWidth(widthMeasureSpec);
        int newHeightSpec = measureHeight(heightMeasureSpec);

        setMeasuredDimension(newWidthSpec, newHeightSpec);
    }

    private int measureWidth(int widthMeasureSpec) {
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int childCount = getChildCount();
        //        int width = DOT_SIZE * (childCount + 2) + mDividerSize * (childCount - 1) + getPaddingLeft() + getPaddingRight();
        int width = DOT_SIZE * childCount + mDividerSize * (childCount - 1) + getPaddingLeft() + getPaddingRight();
        return MeasureSpec.makeMeasureSpec(width, modeWidth);
    }

    private int measureHeight(int heightMeasureSpec) {
        return DOT_SIZE + getPaddingTop() + getPaddingBottom();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int offsetX = getPaddingLeft();
        int offsetY = getPaddingTop();

        Dot child;
        for (int i = 0; i < count; i++) {
            child = (Dot) getChildAt(i);
            child.layout(offsetX, offsetY, offsetX + DOT_SIZE, offsetY + DOT_SIZE);
            offsetX = offsetX + DOT_SIZE + mDividerSize;
            //            if (child.isCurrent()) {
            //                child.layout(offsetX, offsetY, offsetX + 3 * DOT_SIZE, offsetY + DOT_SIZE);
            //                offsetX = offsetX + 3 * DOT_SIZE + mDividerSize;
            //            } else {
            //                child.layout(offsetX, offsetY, offsetX + DOT_SIZE, offsetY + DOT_SIZE);
            //                offsetX = offsetX + DOT_SIZE + mDividerSize;
            //            }
        }
    }

    static class Dot extends View {
        private boolean mCurrent = false;
        private Paint mPaint = new Paint();
        private RectF mRoundRect;
        private Rect mBound = new Rect();

        public Dot(Context context) {
            super(context);
            mRoundRect = new RectF();
        }

        public void setCurrent(boolean isCurrent) {
            mCurrent = isCurrent;
        }

        public boolean isCurrent() {
            return mCurrent;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.getClipBounds(mBound);
            int w = mBound.width();
            int h = mBound.height();
            mPaint.setAntiAlias(true);
            mPaint.setColor(mCurrent ? 0xFFFFFFFF : 0x80FFFFFF);
            mRoundRect.set(0, 0, w, h);

            canvas.drawCircle(w / 2, h / 2, w / 2, mPaint);
            //            if (mCurrent) {
            //                canvas.drawRoundRect(mRoundRect, h / 2, h / 2, mPaint);
            //            } else {
            //                canvas.drawCircle(w / 2, h / 2, w / 2, mPaint);
            //            }
        }
    }

    public static int dpToPx(int dp) {
        return (int) (Resources.getSystem().getDisplayMetrics().density * dp);
    }
}