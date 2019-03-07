package com.sun.demo.utils.AndroidShare;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 18/9/14.
 *
 *



 常见应用包名

 微信朋友圈
 “com.tencent.mm”
 “com.tencent.mm.ui.tools.ShareToTimeLineUI”

 微信朋友
 “com.tencent.mm”
 “com.tencent.mm.ui.tools.ShareImgUI”

 QQ好友
 “com.tencent.mobileqq”
 “com.tencent.mobileqq.activity.JumpActivity”

 QQ空间分享视频
 “com.qzone”
 “com.qzonex.module.maxvideo.activity.QzonePublishVideoActivity”

 QQ空间分享图片、文字
 “com.qzone”
 “com.qzonex.module.operation.ui.QZonePublishMoodActivity”

 新浪微博
 “com.sina.weibo”
 “com.sina.weibo.composerinde.ComposerDispatchActivity”

 */

public class AndroidShare {
    public static List<AppInfoVo> getShareApps(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<AppInfoVo> appInfoVos = new ArrayList<AppInfoVo>();
        List<ResolveInfo> resolveInfos = new ArrayList<ResolveInfo>();
        Intent intent = new Intent(Intent.ACTION_SEND, null);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setType("*/*");
        PackageManager pManager = context.getPackageManager();
        resolveInfos = pManager.queryIntentActivities(intent, PackageManager
                .COMPONENT_ENABLED_STATE_DEFAULT);
        for (int i = 0; i < resolveInfos.size(); i++) {
            AppInfoVo appInfoVo = new AppInfoVo();
            ResolveInfo resolveInfo = resolveInfos.get(i);
            appInfoVo.setAppName(resolveInfo.loadLabel(packageManager).toString());
            appInfoVo.setIcon(resolveInfo.loadIcon(packageManager));
            appInfoVo.setPackageName(resolveInfo.activityInfo.packageName);
            appInfoVo.setLauncherName(resolveInfo.activityInfo.name);
            appInfoVos.add(appInfoVo);
        }
        return appInfoVos;
    }

    public static void shareQQText(Context context, String message) {
        //QQ
        ComponentName comp = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
        //QQ空间
//        ComponentName comp = new ComponentName("com.qzone", "com.qzonex.module.maxvideo.activity.QzonePublishVideoActivity");
        //微信朋友圈
        //ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        //微博
        //ComponentName comp = new ComponentName("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity");
        //微博好友
        //ComponentName comp = new ComponentName("com.sina.weibo", "com.sina.weibo.weiyou.share.WeiyouShareDispatcher");
        //微信
        //ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setComponent(comp);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        context.startActivity(Intent.createChooser(intent, "Share"));
    }

    public static void shareQZoneText(Context context, String message) {
        ComponentName comp = new ComponentName("com.qzone", "com.qzonex.module.maxvideo.activity.QzonePublishVideoActivity");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setComponent(comp);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        context.startActivity(Intent.createChooser(intent, "Share"));
    }

    public static void shareSinaWeiboText(Context context, String message) {
        ComponentName comp = new ComponentName("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setComponent(comp);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        context.startActivity(Intent.createChooser(intent, "Share"));
    }

    public static void shareImage(Context context, String url) {
//        String path = Environment.getExternalStorageDirectory() + File.separator;//sd根目录
//        File file = new File(path, "test" + ".png");//这里test.png是sd卡根目录下的一个图片文件
        Uri imageUri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
        context.startActivity(Intent.createChooser(intent, "Share"));
    }

    public static void shareVideo(Context context, String url) {
//        String path = Environment.getExternalStorageDirectory() + File.separator;//sd根目录
//        File file = new File(path, "test" + ".mp4");
//        Uri audioUri = Uri.fromFile(file);
        Uri audioUri = Uri.parse(url);
        ComponentName comp = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
        Intent shareIntent = new Intent();
        shareIntent.setComponent(comp);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, audioUri);
        shareIntent.setType("audio/*");
        context.startActivity(Intent.createChooser(shareIntent, "分享视频"));
    }

//    public static void shareToQQFriends(Context context){
//        ComponentName comp = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
//        Intent shareIntent = new Intent();
//        shareIntent.setComponent(comp);
//        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
//        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
//        shareIntent.setType("image/*");
//        context.startActivity(Intent.createChooser(shareIntent, "分享多张图片"));
//    }

    /**
     * 分享功能
     *
     * @param context       上下文
     * @param activityTitle Activity的名字
     * @param msgTitle      消息标题
     * @param msgText       消息内容
     * @param imgPath       图片路径，不分享图片则传null
     */
    public static void shareMsg(Context context, String activityTitle, String msgTitle, String msgText,
                                String imgPath) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        if (imgPath == null || imgPath.equals("")) {
            intent.setType("text/plain"); // 纯文本
        } else {
            intent.setType("image/*");
            Uri imageUri = Uri.parse(imgPath);
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
        }
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, activityTitle));
    }
}
