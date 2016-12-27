package com.example.leijianmin.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Created by leijianmin on 2016/11/3.
 */

public class AutoLinearLayout extends FrameLayout {

    private int dividerWidth = 10;
    private int dividerHeight = 20;
    private int mLineCount = 2;   //最大行

    public AutoLinearLayout(Context context) {
        super(context);
    }

    public AutoLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int lineCount = mLineCount;

        int childCount = getChildCount();
        int spanWidth = width - getPaddingLeft() - getPaddingRight();
        int totalHeight = 0;

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        totalHeight = getChildAt(0).getMeasuredHeight();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            if (childWidth == 0 || childHeight == 0) {
                continue;
            }
            if (totalHeight == 0) {
                totalHeight = childHeight;
            }

            if (spanWidth < childWidth + dividerWidth) {
                if (lineCount <= 1) {
                    break;
                }

                totalHeight = totalHeight + childHeight + dividerHeight;
                spanWidth = width - getPaddingLeft() - getPaddingRight();
                lineCount --;
            }
            spanWidth = spanWidth - childWidth - dividerWidth;
        }

        totalHeight = totalHeight + getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(totalHeight, MeasureSpec.EXACTLY));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int offsetX = getPaddingLeft();
        int offsetY = getPaddingTop();
        int lineCount = mLineCount;

        int width = getMeasuredWidth();

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childW = child.getMeasuredWidth();
            int childH = child.getMeasuredHeight();
            if (childW == 0 || childH == 0) {
                continue;
            }
            int newOffsetX = offsetX + childW + dividerWidth;
            if (newOffsetX <= width - getPaddingRight()) {
                child.layout(offsetX, offsetY, offsetX + childW, offsetY + childH);
                offsetX = newOffsetX;
            } else {
                if (lineCount <= 1) {
                    break;
                }

                offsetX = getPaddingLeft();
                offsetY = offsetY + childH + dividerHeight;
                child.layout(offsetX, offsetY, offsetX + childW, offsetY + childH);
                offsetX = offsetX + childW + dividerWidth;

                lineCount --;
            }
        }
    }
}
