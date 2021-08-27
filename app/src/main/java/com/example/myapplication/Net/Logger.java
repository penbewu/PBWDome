package com.example.myapplication.Net;

import com.blankj.utilcode.util.LogUtils;

/**
 * sky
 * 2021/3/23 8:56
 */
public class Logger implements LogInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtils.i("http : " + message);
    }
}