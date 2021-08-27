package com.example.myapplication.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.LogUtils;
import com.example.myapplication.Activitys.WelcomeAct;

/**
 * pengbiwu@Skyworth.com
 * 2021/3/23 16:29
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.e("开机自启");

        //开启mainActivity
        Intent intent2 = new Intent(context, WelcomeAct.class);

        //☆ 如果在广播里面开启Activity 要设置一个任务栈环境
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //在广播接收者里面开启activity
        context.startActivity(intent2);

//        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
//            Intent toIntent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
//            context.startActivity(toIntent);
//        }
    }
}
