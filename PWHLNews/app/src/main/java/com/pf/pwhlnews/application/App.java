package com.pf.pwhlnews.application;

import android.app.Application;

import com.pf.pwhlnews.db.SQLHelper;

/**
 * Created by cuitpf on 2017/6/13.
 */

public class App extends Application {
    private static App mAppApplication;
    private SQLHelper sqlHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;
        sqlHelper = getSQLHelper();
    }

    /**
     * 获取Application
     */
    public static App getApp() {
        return mAppApplication;
    }

    /**
     * 获取数据库Helper
     */
    public SQLHelper getSQLHelper() {
        if (sqlHelper == null)
            sqlHelper = new SQLHelper(mAppApplication);
        return sqlHelper;
    }

    @Override
    public void onTerminate() {
        if (sqlHelper != null)
            sqlHelper.close();
        super.onTerminate();
        // 整体摧毁的时候调用这个方法
    }
}