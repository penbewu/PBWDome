package com.example.myapplication.Presenter;

/**
 * sky
 * 2021/3/19 14:38
 */
public interface Presenter<V> {
    void attachView(V view);
    void detachView();
    boolean isViewAttached();
}
