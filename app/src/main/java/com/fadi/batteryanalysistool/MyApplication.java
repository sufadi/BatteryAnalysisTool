package com.fadi.batteryanalysistool;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.fadi.batteryanalysistool.util.AppInfoUtils;
import com.fadi.batteryanalysistool.util.Constant;
import com.fadi.batteryanalysistool.util.ShareUtil;

/**
 * Created by fadi.su on 2018/5/16.
 */
public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        isFistRun();
    }

    private boolean isFistRun() {
        boolean result = false;

        String curVersionName = AppInfoUtils.getVersionName(this);

        ShareUtil mShareUtil = new ShareUtil(getApplicationContext());
        if (!curVersionName.equals(mShareUtil.getString(Constant.KEY_VERSION_NAME, "v1.0"))) {
            mShareUtil.setShare(Constant.KEY_VERSION_NAME, curVersionName);
            result = true;
        }
        return result;
    }

}
