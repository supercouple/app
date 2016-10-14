package com.zhongyou.activity_manage_library;

import android.app.Activity;

import java.util.HashMap;

/**
 * Created by Tang on 2016/9/29.
 */
public class ActivityManager {
    private HashMap<String, Activity> activityMap = new HashMap<String, Activity>();

    private static ActivityManager activityManager;

    /**
     * 单例模式
     *
     * @return
     */
    public static synchronized ActivityManager getInstance() {
        if (activityManager == null) {
            activityManager = new ActivityManager();
        }
        return activityManager;
    }

    /**
     * 往map中添加activity
     *
     * @param activityName
     *            包名加类名
     * @param activity
     */
    public void addActivity(String activityName, Activity activity) {
        activityMap.put(activityName, activity);
    }

    /**
     * 从map中移除activity
     *
     * @param activityName
     *            包名加类名
     */
    public void removeActivity(String activityName) {
        if (isActivityExist(activityName)) {
            activityMap.remove(activityName);
        }

    }

    /**
     * 判断activity是否存在
     *
     * @param activityName
     *            包名加类名
     *
     * @return
     */
    public boolean isActivityExist(String activityName) {
        return activityMap.containsKey(activityName);
    }

    /**
     * 获取activity对象
     *
     * @param activityName
     *            包名加类名
     * @return
     */
    public Activity getActivity(String activityName) {
        if (isActivityExist(activityName)) {
            return activityMap.get(activityName);
        }
        return null;
    }


    /**
     * 移除并关闭一个Activity
     * @param activityName 包名加类名
     */
    public void closeActivity(String activityName) {
        if (isActivityExist(activityName)) {
            Activity activity = activityMap.get(activityName);
            if(activity!=null)activityMap.get(activityName).finish();
            removeActivity(activityName);
        }
    }
    /**
     * 移除并关闭所有Activity
     */
    public void closeAllActivity(){
        for (String key : activityMap.keySet()) {
            Activity activity = activityMap.get(key);
            if(activity!=null)activityMap.get(key).finish();
            removeActivity(key);
        }
    }
    /**
     * 移除并关闭非当前Activity
     * @param activityName 包名加类名
     */
    public void closeOtherActivity(String activityName){
        for (String key : activityMap.keySet()) {
            if(key.equals(activityName))continue;
            Activity activity = activityMap.get(key);
            if(activity!=null)activityMap.get(key).finish();
            removeActivity(key);
        }
    }
}

