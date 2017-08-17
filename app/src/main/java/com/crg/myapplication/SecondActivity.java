package com.crg.myapplication;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by chenronggang on 2017/8/17.
 */

public class SecondActivity extends AppCompatActivity {

    public static final String TAG = SecondActivity.class.getSimpleName();
    private Button mButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG, TAG + " onCreate() <<=======>>>getTaskId:" + getTaskId());
        mButton = (Button) findViewById(R.id.button_second);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, TAG + " onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, TAG + " onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, TAG + " onResume() <<=======>>>getTaskId:" + getTaskId());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, TAG + " onPause()");
//        displayBriefMemory();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, TAG + " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, TAG + " onDestroy()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, TAG + " onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, TAG + " onRestoreInstanceState()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, TAG + " onNewIntent()");
    }

    private void displayBriefMemory() {
        final ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(info);
        Log.i(TAG, "系统剩余内存:" + (info.availMem >> 10) + "k");
        Log.i(TAG, "系统是否处于低内存运行：" + info.lowMemory);
        Log.i(TAG, "当系统剩余内存低于" + (info.threshold >> 10) + "k" + "时就看成低内存运行");
    }
}
