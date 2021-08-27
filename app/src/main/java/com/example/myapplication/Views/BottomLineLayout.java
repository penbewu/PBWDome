package com.example.myapplication.Views;

/**
 * sky
 * 2021/3/22 11:18
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

/**
 * @Author: duke
 * @DateTime: 2017-04-22 21:59
 * @Description:
 */
public class BottomLineLayout extends LinearLayout {
    private int itemDefaultBgResId = R.drawable.normal_circle;//单个元素默认背景样式
    private int itemSelectedBgResId = R.drawable.select_circle;//单个元素选中背景样式
    private int currentPosition;//当前选中位置
    private int itemHeight = 50;//item宽高
    private int itemMargin = 5;//item间距

    public BottomLineLayout(Context context) {
        this(context, null, 0);
    }

    public BottomLineLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomLineLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    public void initViews(int count, int itemHeight, int itemMargin) {
        this.itemHeight = itemHeight;
        this.itemMargin = itemMargin;
        removeAllViews();
        if(count == 0 || itemHeight == 0){
            return;
        }
        View view = createView(itemHeight,itemMargin);
        view.setBackgroundResource(itemSelectedBgResId);
        addView(view);
        if(count == 1){
            return;
        }
        for (int i = 1; i < count; i++) {
            view = createView(itemHeight,itemMargin);
            view.setBackgroundResource(itemDefaultBgResId);
            addView(view);
        }
    }

    /**
     * 创建view
     * @param sideLength 边长
     * @param itemMargin 外间距
     * @return
     */
    public View createView(int sideLength,int itemMargin){
        TextView textview = new TextView(getContext());
        LinearLayout.LayoutParams params = new LayoutParams(sideLength, sideLength);
        if(itemMargin > 0){
            params.setMargins(itemMargin,0,itemMargin,0);
        }
        textview.setLayoutParams(params);
        return textview;
    }

    //切换到目标位置
    public void changePosition(int position) {
        if(getChildCount() <= 1){
            return;
        }
        getChildAt(currentPosition).setBackgroundResource(itemDefaultBgResId);
        currentPosition = position % getChildCount();
        getChildAt(currentPosition).setBackgroundResource(itemSelectedBgResId);
    }

//
//    bottomLineLayout = (BottomLineLayout) findViewById(R.id.bottomlayoutl);
//bottomLineLayout.initViews(item个数,item宽高,item外间距);
//
//viewPager.addOnPageChangeListener(new MyOnPageChangeListener() {
//        @Override
//        public void onPageSelected(int position) {
//            if(bottomLineLayout != null){
//                bottomLineLayout.changePosition(position);
//            }
//        }
//    });

}
