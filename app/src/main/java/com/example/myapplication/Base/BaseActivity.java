package com.example.myapplication.Base;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.EvenBusUtil.EventBusUtils;
import com.example.myapplication.EvenBusUtil.EventMessage;
import com.example.myapplication.IView.BaseView;
import com.example.myapplication.R;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/** 基类
 * sky
 * 2021/3/18 15:05
 */

public  class BaseActivity extends AppCompatActivity implements BaseView {
    /**
     * 记录处于前台的Activity
     */
    private static BaseActivity mForegroundActivity = null;

    private Unbinder unbinder; //ButterKnife
    private int layid=0;  //lay布局
    private boolean isReg;  //是否开启evenbus

    //进度条
//    ProgressDialog progressDialog;

    public  BaseActivity(int layid){
        this.layid=layid;
    }

    public   BaseActivity(int layid,boolean isReg){
        this.isReg=isReg;
        this.layid =layid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);//并且需要在

        BaseApplication.getInstance().addActivity(this);
        //设置布局
        setContentView(layid);
        unbinder = ButterKnife.bind(this);
        if (isReg) {
            EventBusUtils.register(this);
        }

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("正在加载数据");

        //初始化控件
        initView();
        //设置数据
        initData();

        // initActionBar();
    }


    @Override
    protected void onResume() {
        mForegroundActivity = this;
        super.onResume();
    }

    @Override
    protected void onPause() {
        mForegroundActivity = null;
        super.onPause();
    }

    public void initView(){}

    public void initData(){}

    public void initActionBar() {

    }

//    @Override
//    public void hideLoading() {
//        if (null!=progressDialog&&progressDialog.isShowing()) {
//            progressDialog.dismiss();
//        }
//    }
//
//    @Override
//    public void showLoading() {
//        if (null!=progressDialog&&!progressDialog.isShowing()) {
//            progressDialog.show();
//        }
//    }
    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }
    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    /**
     * 获取当前处于前台的activity
     */
    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    @Override
    protected void onDestroy() {
        BaseApplication.getInstance().removeActivity(this);
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
