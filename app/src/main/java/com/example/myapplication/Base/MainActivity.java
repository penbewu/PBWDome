package com.example.myapplication.Base;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.EvenBusUtil.EventBusUtils;
import com.example.myapplication.EvenBusUtil.EventMessage;
import com.example.myapplication.Fragments.SettingFrag;
import com.example.myapplication.IView.MvpView;
import com.example.myapplication.Presenter.MvpPresenter;
import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * sky
 * 2021/3/19 11:51
 */
public class MainActivity extends BaseActivity implements MvpView {

    MvpPresenter presenter;
    @BindView(R.id.text)
    TextView text;

    public MainActivity(){
        super(R.layout.activity_main,true);
    }

    @Override
    public void initView() {
        //初始化Presenter
        presenter = new MvpPresenter(this);
    }

    @Override
    public void showData(Object data) {
        text.setText((String)data);
    }

//    @Override
//    public void showFailureMessage(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//        text.setText(msg);
//    }

//    @Override
//    public void showErrorMessage() {
//        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
//        text.setText("网络请求数据出现异常");
//    }

    @OnClick({R.id.data_but, R.id.failure_but, R.id.error_but, R.id.test_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.data_but:
//                presenter.getData("normal_circle", true);
//                PubAct.startAct(MainActivity.this,new SettingFrag());
                presenter.getNews();
                break;
            case R.id.failure_but:
//                presenter.getData("failure", true);
                presenter.get();
                break;
            case R.id.error_but:
                presenter.getData("error", true);

                startActivity(new Intent(this,PubAct.class));
                break;
            case R.id.test_but:
                EventBusUtils.post(new EventMessage(1, null));
                break;

        }
    }

    @Override
    public void handleEvent(EventMessage event) {
        switch (event.getCode()) {
            case 1:
                text.setText("你好,测试用");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
