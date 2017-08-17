package com.crg.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by chenronggang on 2017/8/17.
 */

public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();

    public MyApplication() {
        super();
        Log.i(TAG, TAG + " MyApplication()=========");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.i(TAG, TAG + " attachBaseContext=========");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
        Log.i(TAG, TAG + " onCreate=========");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, TAG + " onConfigurationChanged=========: " + newConfig.describeContents());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, TAG + " onLowMemory=========");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i(TAG, TAG + " onTerminate=========");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG, TAG + " onTrimMemory: level========= " + level);
    }

    public ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.i(TAG, TAG + " =========onActivityCreated");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.i(TAG, TAG + " =========onActivityStarted");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.i(TAG, TAG + " =========onActivityResumed");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.i(TAG, TAG + " =========onActivityPaused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.i(TAG, TAG + " =========onActivityStopped");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.i(TAG, TAG + " =========onActivitySaveInstanceState");
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.i(TAG, TAG + " =========onActivityDestroyed");
        }
    };
}
