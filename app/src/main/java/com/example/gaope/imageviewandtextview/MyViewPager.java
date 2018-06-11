package com.example.gaope.imageviewandtextview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 解决ViewPager与PhotoView的滑动冲突
 * 于viewpager的切换页面与photoview的放大缩小有时会有手势冲突.
 * 当缩放到最小时会报出异常
 * Created by gaope on 2018/6/5.
 */

public class MyViewPager extends ViewPager {

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        try {
            return super.onInterceptTouchEvent(ev);
        }catch (IllegalArgumentException e){
            return false;
        }

    }
}
