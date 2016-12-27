package com.example.leijianmin.myapplication.houseparty;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.reflect.Field;

/**
 * Created by leijianmin on 2016/12/26.
 */

public class DropdownLayout extends FrameLayout {
    private static final int MIN_FLING_VELOCITY = 400;  // 可以检测到的触摸速度
    private static final int TOP_BAR_HEIGHT = 50; //dp
    private static final String DRAG_VIEW_TAG = "drag_view";

    private ViewDragHelper mViewDragHelper;

    private int mTopBarHeight;

    public DropdownLayout(Context context) {
        super(context);
        init();
    }

    public DropdownLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DropdownLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        final float density = getResources().getDisplayMetrics().density;
        final float minVel = MIN_FLING_VELOCITY * density;

        mTopBarHeight = (int) (density * TOP_BAR_HEIGHT + 0.5f);

        mViewDragHelper = ViewDragHelper.create(this, new ViewDragCallback());
        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_TOP | ViewDragHelper.EDGE_BOTTOM);
        mViewDragHelper.setMinVelocity(minVel);

        setDragHelperEdgeSize();
    }

    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        try {
            return mViewDragHelper.shouldInterceptTouchEvent(event);
        } catch (ArrayIndexOutOfBoundsException e) {
            // FIXME: handle exception
            // issues #9
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    private float getViewOffset(View view) {
        return view.getTop();
    }


    class ViewDragCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return false;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return top > 0 ? 0 : top;
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            final float offset = getViewOffset(releasedChild);
            int top = 0;

            if (offset < -releasedChild.getHeight() / 2) {
                top = -releasedChild.getHeight() + mTopBarHeight;
            }

            if (yvel < -mViewDragHelper.getMinVelocity()) {
                top = -releasedChild.getHeight() + mTopBarHeight;
            } else if (yvel > mViewDragHelper.getMinVelocity()) {
                top = 0;
            }

            mViewDragHelper.smoothSlideViewTo(releasedChild, releasedChild.getLeft(), top);
            invalidate();
        }

        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            if ((edgeFlags & ViewDragHelper.EDGE_TOP) == ViewDragHelper.EDGE_TOP
                    || ((edgeFlags & ViewDragHelper.EDGE_BOTTOM) == ViewDragHelper.EDGE_BOTTOM)) {
                View child = getDragView();
                if (child != null) {
                    mViewDragHelper.captureChildView(child, pointerId);
                }
            }
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return child.getHeight();
        }

    }

    private View getDragView() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getTag() != null && child.getTag().equals(DRAG_VIEW_TAG)) {
                return child;
            }
        }
        return null;
    }

    /**
     * 反射修改mEdgeSize
     */
    private void setDragHelperEdgeSize() {
        int edgeSize = mTopBarHeight;
        Field field = null;
        try {
            field = mViewDragHelper.getClass().getDeclaredField("mEdgeSize");
            field.setAccessible(true);
            field.set(mViewDragHelper, edgeSize);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void expandOrShrink() {
        View dragView = getDragView();
        if (dragView != null) {
            int top = dragView.getTop();

            if (top >= 0) {
                mViewDragHelper.smoothSlideViewTo(dragView, dragView.getLeft(), -dragView.getHeight() + mTopBarHeight);
            } else {
                mViewDragHelper.smoothSlideViewTo(dragView, dragView.getLeft(), 0);
            }

            invalidate();
        }
    }
}
