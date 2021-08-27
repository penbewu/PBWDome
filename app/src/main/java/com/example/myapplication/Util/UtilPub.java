package com.example.myapplication.Util;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.RecyclerviewUtil.RecycleViewDivider;

/**
 * sky
 * 2021/3/18 17:02
 */
public class UtilPub {
    /**
     * 公共设置 RecyclerView基本配制
     * @param context
     * @param whether
     * @param recyclerView
     */
    public static void setRec(Context context, RecyclerView recyclerView, boolean whether) {
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() <= 0||whether) {
            //添加Android自带的分割线
            recyclerView.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.HORIZONTAL));
//            recyclerView.addItemDecoration(new SpacesItemDecoration(context, id));
        }
    }
}
