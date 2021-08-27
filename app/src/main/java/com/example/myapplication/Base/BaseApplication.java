package com.example.myapplication.Base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.LinkedList;
import java.util.List;

/**
 * sky
 * 2021/3/18 17:05
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;
    private static Context appContext;
    private static  List<Activity> mActivities = new LinkedList<Activity>();


    public static  synchronized BaseApplication getInstance(){
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        appContext=instance.getApplicationContext();
    }
    /**
     * 添加activity
     */
    public void addActivity(Activity act) {
        if (mActivities != null) {
            mActivities.add(act);
        }
    }
    /**
     * 移除activity
     */
    public void removeActivity(Activity act) {
        if (mActivities != null) {
            mActivities.remove(act);
        }
    }
    /**
     * 退出app
     */
    public void exitApp() {
        if (mActivities != null) {
            synchronized (mActivities) {
                for (Activity act : mActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 这还有一系列的第三方module的初始化
     */
}
