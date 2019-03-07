package com.sun.demo.manager;

import android.content.Context;
import android.content.Intent;

import com.sun.demo.home.StocksActivity;
import com.sun.demo.home.StocksBriefActivity;


/**
 * Created by sun on 17/12/14.
 */

public class UIManager<T> {
    private static UIManager instance;

    public static UIManager getInstance() {
        if (instance == null) {
            synchronized (UIManager.class) {
                if (instance == null) {
                    instance = new UIManager();
                }
            }
        }
        return instance;
    }

    private UIManager() {
    }


    /**
     * 仓库
     *
     * @param context
     */
    public void showStocksActivity(Context context) {
        context.startActivity(new Intent(context, StocksActivity.class));
    }

    /**
     * 仓库简介
     *
     * @param context
     */
    public void showStocksBriefActivity(Context context) {
        context.startActivity(new Intent(context, StocksBriefActivity.class));
    }


}
