package com.example.myapplication.Mode;

import android.content.Context;
import android.os.Handler;

import com.example.myapplication.Net.Demo;
import com.example.myapplication.Net.MyObserver;
import com.example.myapplication.Net.RequestUtils;

/**
 * sky
 * 2021/3/19 11:45
 */
public class MvpModel {
    /**
     * 获取网络接口数据
     * @param param 请求参数
     * @param callback 数据回调接口
     */
    public static void getNetData(final String param ,final MvpCallback callback){
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case "normal_circle":
                        callback.onSuccess("根据参数"+param+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }

    public static void getDome(Context context, final String param , final MvpCallback callback){
        MyObserver myObserver = new MyObserver<Demo>(context) {
            @Override
            public void onSuccess(Demo result) {
                callback.onSuccess(result);
            }
            @Override
            public void onFailure(Throwable e, String errorMsg) {
                callback.onFailure(errorMsg);
            }
        };
        RequestUtils.getDemo(context,myObserver);
    }
}
