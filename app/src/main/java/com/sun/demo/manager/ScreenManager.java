package com.sun.demo.manager;

import android.app.Activity;

import com.sun.demo.home.HomeActivity;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Created by sun on 17/12/14.
 * * Activity 管理栈
 */

public class ScreenManager {

    private static ScreenManager instance;

    public static ScreenManager getInstance() {
        if (null == instance) {
            synchronized (ScreenManager.class) {
                if (null == instance) {
                    instance = new ScreenManager();
                }
            }
        }
        return instance;
    }

    private Deque<Activity> activityStack = new ArrayDeque<>();

    private ScreenManager() {
    }

    public void popAllActivityExcept(Class cls) {
        while (!activityStack.isEmpty()) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(HomeActivity.class)) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
            activity.finish();
        }
    }

    /*
    * 仅供app退出时调用！！！
    */
    public void popAllActivity() {
        while (!activityStack.isEmpty()) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }

            popActivity(activity);
            activity.finish();
        }
    }

    public void popActivity(Activity activity) {
        if (!activityStack.isEmpty() && null != activity) {
            activityStack.remove(activity);
        }
    }

    public void removeHomeActivity(Activity except) {
        if (!activityStack.isEmpty()) {
            for (Activity activity : activityStack) {
                //之前从SettingActivity现在从SwitchRoleActivity作为切换角色的跳板，这个activity不能finish
                // activity instanceof except
                if (activity.getClass().equals(except.getClass())) {
                    continue;
                }
                activity.finish();
            }
        }
    }

    public void popTopNActivity(int n) {
        for (int i = 0; i < n; i++) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            popActivity(activity);
            activity.finish();
        }
    }

    public void pushActivity(Activity activity) {
        if (null == activityStack) {
            activityStack = new ArrayDeque<>();
        }
        activityStack.addFirst(activity);
    }

    public Activity currentActivity() {
        if (!activityStack.isEmpty()) {
            return activityStack.peekFirst();
        }
        return null;
    }

    public void finishCurrentActivity() {
        Activity activity = currentActivity();
        if (activity != null) {
            popActivity(activity);
            activity.finish();
        }
    }

    public int getStackSize() {
        if (activityStack == null) {
            return 0;
        }
        return activityStack.size();
    }

    public boolean hasHomeActivity() {
        for (Activity activity : activityStack) {
            if (activity instanceof HomeActivity) {
                return true;
            }
        }
        return false;
    }
}
