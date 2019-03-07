package com.sun.demo.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by sun on 18/8/18.
 */

public class MyCountDownTimer extends CountDownTimer {
    private TextView textView;
    private Finish finish;

    public MyCountDownTimer(long millisInFuture, long countDownInterval, TextView textView, Finish finish) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
        this.finish = finish;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long time = millisUntilFinished / 1000;
        if (time <= 59) {
            textView.setText(String.format("00:%02d", time));
        } else {
            textView.setText(String.format("%02d:%02d", time / 60, time % 60));
        }
    }

    @Override
    public void onFinish() {
        finish.finish();
    }

    public interface Finish {
        void finish();
    }
}
