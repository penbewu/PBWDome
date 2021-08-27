package com.example.myapplication.IView;

/**
 * sky
 * 2021/3/19 11:46
 */
public interface MvpView extends BaseView{
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(Object data);
//    /**
//     * 当数据请求失败后，调用此接口提示
//     * @param msg 失败原因
//     */
//    void showFailureMessage(String msg);
}