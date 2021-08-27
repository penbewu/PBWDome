package com.example.myapplication.Base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.EvenBusUtil.EventBusUtils;
import com.example.myapplication.EvenBusUtil.EventMessage;
import com.example.myapplication.IView.BaseView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * sky
 * 2021/3/19 16:39
 */
public class BaseFragment extends Fragment implements BaseView {
//        public abstract int getContentViewId();
//    protected abstract void initAllMembersView(Bundle savedInstanceState);
    protected Context mContext;
    protected View mRootView;
    private Unbinder unbinder; //ButterKnife
    private int layid=0;  //lay布局
    private boolean isReg;  //是否开启ev

    public  BaseFragment(int layid){
        this.layid=layid;
    }

    public   BaseFragment(int layid,boolean isReg){
        this.isReg=isReg;
        this.layid =layid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mContext = getActivity();
        mRootView = inflater.inflate(layid, container, false);
//        initAllMembersView(savedInstanceState);

        unbinder = ButterKnife.bind(this,mRootView);
        if (isReg) {
            EventBusUtils.register(this);
        }

        //初始化控件
        initView();
        //设置数据
        initData();
        return mRootView;
    }


    public void initView(){}

    public void initData(){}

//    @Override
//    public void showLoading() {
//        checkActivityAttached();
//        ((BaseActivity) mContext).showLoading();
//    }
//
//    public void showLoading(String msg) {
//        checkActivityAttached();
//        ((BaseActivity) mContext).showLoading();
//    }
//    @Override
//    public void hideLoading() {
//        checkActivityAttached();
//        ((BaseActivity) mContext).hideLoading();
//    }
    @Override
    public void showToast(String msg) {
        checkActivityAttached();
        ((BaseActivity) mContext).showToast(msg);
    }
    @Override
    public void showErr() {
        checkActivityAttached();
        ((BaseActivity) mContext).showErr();
    }
    protected boolean isAttachedContext(){
        return getActivity() != null;
    }
    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }
    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }

//    @Override
//    protected void onDestroy() {
//        BaseApplication.getInstance().removeActivity(this);
//        unbinder.unbind();
//        if (isReg) {
//            EventBusUtils.unregister(this);
//        }
//        super.onDestroy();
//    }


    @Override
    public void onDestroy() {
        unbinder.unbind();
        if (isReg) {
            EventBusUtils.unregister(this);
        }
        super.onDestroy();
    }

    /**
     * 接收到分发的事件
     *
     * @param event 事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(EventMessage event) {
        handleEvent(event);
    }
    public void handleEvent(EventMessage event){}

    public void handleStickyEvent(EventMessage event){}
    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveStickyEvent(EventMessage event) {
        handleStickyEvent(event);
    }
}
