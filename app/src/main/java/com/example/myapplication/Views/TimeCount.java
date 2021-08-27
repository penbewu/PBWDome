package com.example.myapplication.Views;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * sky
 * 2021/3/19 10:19
 */
public class TimeCount extends CountDownTimer {
    private TextView tvCode;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimeCount(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tvCode = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
//        tvCode.setBackgroundResource(R.drawable.regist_suc);
        tvCode.setTextSize(12);
        tvCode.setText(millisUntilFinished / 1000
//                + ContextUtil.INSTANCE.getContext().getString(R.string.one_second)
               +"" );
        tvCode.setClickable(false);

    }

    @Override
    public void onFinish() {
//        tvCode.setBackgroundResource(R.drawable.regist_suc);
        tvCode.setTextSize(12);
//        tvCode.setText(R.string.receive_again);
        tvCode.setClickable(true);
    }


}
