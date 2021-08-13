package com.hui.forceofflinetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if (action!=null){
            switch (action){
                case Intent.ACTION_SCREEN_ON:
                    Log.e(TAG, "onReceive: 屏幕开启");
                    break;
                case Intent.ACTION_SCREEN_OFF:
                    Log.e(TAG, "onReceive: 屏幕关闭");
                    break;
                case Intent.ACTION_USER_PRESENT:
                    Log.e(TAG, "onReceive: 解锁屏幕");
                    break;
                default:
                    break;
            }
        }
    }
}

