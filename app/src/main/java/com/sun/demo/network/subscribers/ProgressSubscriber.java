package com.sun.demo.network.subscribers;

import android.content.Context;
import android.widget.Toast;


import com.sun.demo.network.progress.ProgressCancelListener;
import com.sun.demo.network.progress.ProgressDialogHandler;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Created by sun on 18/1/22.
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    private Context mContext;
    private SubscriberOnNextListener mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private SubscriberOnCompletedListener mSubscriberOnCompletedListener;
    private SubscriberOnErrorListener mSubscriberOnErrorListener;

    //    public ProgressSubscriber(Context mContext, SubscriberOnNextListener mSubscriberOnNextListener, SubscriberOnCompletedListener mSubscriberOnCompletedListener, SubscriberOnErrorListener mSubscriberOnErrorListener) {
//        this.mContext = mContext;
//        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
//        this.mSubscriberOnCompletedListener = mSubscriberOnCompletedListener;
//        this.mSubscriberOnErrorListener = mSubscriberOnErrorListener;
//        this.mProgressDialogHandler = new ProgressDialogHandler(mContext, this, true);
//    }
    public ProgressSubscriber(Context mContext, SubscriberOnNextListener mSubscriberOnNextListener, SubscriberOnErrorListener subscriberOnErrorListener, boolean isShow, String dialogMessage) {
        this.mContext = mContext;
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.mSubscriberOnErrorListener = subscriberOnErrorListener;
        this.mProgressDialogHandler = new ProgressDialogHandler(mContext, this, true, dialogMessage, isShow);
    }

    public ProgressSubscriber(Context mContext, SubscriberOnNextListener mSubscriberOnNextListener, boolean isShow, String dialogMessage) {
        this.mContext = mContext;
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.mProgressDialogHandler = new ProgressDialogHandler(mContext, this, true, dialogMessage, isShow);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
        if (mSubscriberOnCompletedListener != null) {
            mSubscriberOnCompletedListener.OnCompleted();
        }
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();

        if (e instanceof SocketTimeoutException) {
            Toast.makeText(mContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(mContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        }
        if (e.getMessage().equals("HTTP 404 NOT Found")) {
            Toast.makeText(mContext, "网络中断，请检查您的网络状态(404)", Toast.LENGTH_SHORT).show();
        }
        if (mSubscriberOnErrorListener != null) {
            mSubscriberOnErrorListener.OnError(e);
        }
    }

    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
