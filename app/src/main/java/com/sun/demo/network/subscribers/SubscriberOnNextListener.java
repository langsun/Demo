package com.sun.demo.network.subscribers;

/**
 * Created by sun on 18/1/22.
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}
