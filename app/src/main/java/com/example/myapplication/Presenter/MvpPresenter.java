package com.example.myapplication.Presenter;

import com.example.myapplication.Base.BaseActivity;
import com.example.myapplication.IView.MvpView;
import com.example.myapplication.Mode.MvpCallback;
import com.example.myapplication.Mode.MvpModel;

/**
 * sky
 * 2021/3/19 11:47
 */
public class MvpPresenter implements Presenter <MvpView>{
    // View接口
    private MvpView mView;
    public MvpPresenter(MvpView view){
        attachView(view);
    }

    private boolean isLoad;
    /**
     * 获取网络数据
     * @param params 参数
     */
    public void getData(String params,boolean isLoad) {
        if (!isViewAttached())
            return;

        this.isLoad = isLoad;
        //显示正在加载进度条
//        if (mView instanceof BaseActivity && isLoad)
//            ((BaseActivity) mView).showLoading();
        // 调用Model请求数据

        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(Object data) {
                if (data instanceof String)
                    mView.showData(((String) data));
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                if (mView instanceof BaseActivity)
                    ((BaseActivity) mView).showToast(msg);
            }

            @Override
            public void onError() {
//                Toast.makeText()
                if (mView instanceof BaseActivity)
                    ((BaseActivity) mView).showErr();
            }

            @Override
            public void onComplete() {
//                if (mView instanceof BaseActivity && isLoad)
//                    ((BaseActivity) mView).hideLoading();
            }
        });

//        MvpModel.getNetData(params, new MvpCallback() {
//            @Override
//            public void onSuccess(String data) {
//                //调用view接口显示数据
//                mView.showData(data);
//            }
//            @Override
//            public void onFailure(String msg) {
//                //调用view接口提示失败信息
//                mView.showFailureMessage(msg);
//            }
//            @Override
//            public void onError() {
//                //调用view接口提示请求异常
//                mView.showErrorMessage();
//            }
//            @Override
//            public void onComplete() {
//                // 隐藏正在加载进度条
//                if (mView instanceof  BaseActivity &&isLoad)
//                    ((BaseActivity)mView).hideLoading();
//            }
//        });
//        Activity activity = null;
//        if (mView instanceof Activity)
//            activity =(Activity) mView;
//        else if (mView instanceof Fragment)
//            activity =((Fragment) mView).getActivity();
    }

    public void get(){
        if (!isViewAttached())
            return;

        MvpModel.getDome(mView.getContext(), "", new MvpCallback() {
            @Override
            public void onSuccess(Object data) {
                mView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
            }

            @Override
            public void onError() {
            }

            @Override
            public void onComplete() {
            }
        });

    }

    @Override
    public void attachView(MvpView view) {
        this.mView =view;
    }

    @Override
    public void detachView() {
        this.mView =null;
    }

    @Override
    public boolean isViewAttached() {
        return null!=mView;
    }

    //    @Override
//    public void loadDataSuccess(Object object) {
//        // 隐藏正在加载进度条
//        if (mView instanceof BaseActivity && isLoad)
//            ((BaseActivity) mView).hideLoading();
//
//        if (object instanceof  String){
//            mView.showData((String) object);
//        }
//    }
//
//    @Override
//    public void loadDataFailure(String mas) {
//        // 隐藏正在加载进度条
//        if (mView instanceof BaseActivity && isLoad)
//            ((BaseActivity) mView).hideLoading();
//
//            mView.showFailureMessage(mas);
//    }
}
