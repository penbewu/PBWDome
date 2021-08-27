package com.example.myapplication.Activitys;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.example.myapplication.Base.BaseActivity;
import com.example.myapplication.Base.MainActivity;
import com.example.myapplication.Base.PubAct;
import com.example.myapplication.Fragments.GuidanceFrag;
import com.example.myapplication.R;
import com.example.myapplication.Util.PubStaic;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * sky
 * 2021/3/19 17:49
 */
public class WelcomeAct extends BaseActivity {
    @BindView(R.id.imag)
    ImageView imag;
    @BindView(R.id.time_tex)
    TextView timeTex;

    public WelcomeAct() {
        super(R.layout.welcome_frag);
    }

    private CountDownTimer countDownTimer;
    private int time = 5;

    @Override
    public void initView() {
        countDownTimer = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeTex.setText(time-- + "");
            }

            @Override
            public void onFinish() {
                cancel();
                time = 5;
                if (StringUtils.equals(SPUtils.getInstance().getString(PubStaic.FIRST,
                        ""),"ok")){
                    ActivityUtils.startActivity(new Intent(WelcomeAct.this, MainActivity.class));
                }else
                PubAct.startAct(WelcomeAct.this,new GuidanceFrag());
                finish();
            }
        };
        countDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        countDownTimer = null;
        super.onDestroy();
    }

    @OnClick(R.id.time_tex)
    public void onViewClicked() {
        countDownTimer.cancel();
        ActivityUtils.startActivity(new Intent(WelcomeAct.this, MainActivity.class));
        finish();
    }
}
