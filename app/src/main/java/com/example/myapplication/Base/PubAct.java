package com.example.myapplication.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.R;

import butterknife.BindView;

/**
 * sky
 * 2021/3/18 18:14
 */
public class PubAct extends BaseActivity {

    @BindView(R.id.frame)
    FrameLayout frame;
    private BaseFragment baseFragment;

    public PubAct() {
        super(R.layout.pub_act, true);
    }
//
//    @Override
//    public void initView() {
////        baseFragment =new WelcomeFrag();
////        FragmentUtils.addFragment(getSupportFragmentManager(),baseFragment,R.id.frame);
//    }


    private static BaseFragment tClass;

    private static Class<Fragment> aClass;

    public static void startAct(Context context, BaseFragment tClass) {
        PubAct.tClass = tClass;
        context.startActivity(new Intent(context, PubAct.class));
    }


    public static void startAct(Context context, BaseFragment tClass, Bundle bundle) {
        PubAct.tClass = tClass;
        tClass.setArguments(bundle);
        context.startActivity(new Intent(context, PubAct.class));
    }

    public static void startAct(Context context, Class<Fragment> aClass) {
        PubAct.aClass = aClass;
        context.startActivity(new Intent(context, PubAct.class));
    }

    @Override
    public void initView() {
//        Uiutils.setLiuHaiStyle(this,mainLin);


//        FrameLayout.LayoutParams lps = (FrameLayout.LayoutParams) frame.getLayoutParams();
//        lps.rightMargin = Uiutils.getNavigationBarHeight(this);
//        mainLin.setLayoutParams(lps);

        getWindow().setLayout(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);//需要添加的语句
        FragmentManager fm = getSupportFragmentManager();
        if (PubAct.tClass != null) {
            fm.beginTransaction().add(R.id.frame, PubAct.tClass)
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PubAct.tClass = null;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

}


//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.pub_act);
//
//        baseFragment =new WelcomeFrag();
//        FragmentUtils.addFragment(getSupportFragmentManager(),baseFragment,R.id.frame);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//}
