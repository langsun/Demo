package com.sun.demo.utils.AndroidShare;

import android.graphics.drawable.Drawable;

/**
 * Created by sun on 18/9/14.
 *
 * https://blog.csdn.net/u010356768/article/details/78249300?fps=1&locationNum=1
 */

public class AppInfoVo {
    private Drawable icon;
    private String appName;
    private String packageName;
    private boolean isSystemApp;
    private long codesize;
    private String launcherName;


    public String getLauncherName() {
        return launcherName;
    }

    public void setLauncherName(String launcherName) {
        this.launcherName = launcherName;
    }

    public long getCodesize() {
        return codesize;
    }

    public void setCodesize(long codesize) {
        this.codesize = codesize;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isSystemApp() {
        return isSystemApp;
    }

    public void setSystemApp(boolean isSystemApp) {
        this.isSystemApp = isSystemApp;
    }

    @Override
    public String toString() {
        return "AppInfoVo{" +
                "icon=" + icon +
                ", appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", isSystemApp=" + isSystemApp +
                ", codesize=" + codesize +
                ", launcherName='" + launcherName + '\'' +
                '}';
    }
}
