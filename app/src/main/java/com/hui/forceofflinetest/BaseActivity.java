package com.hui.forceofflinetest;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver offlineReceiver;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.hui.forceofflinetest.FORCE_OFFLINE");
        offlineReceiver=new ForceOfflineReceiver();
        registerReceiver(offlineReceiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineReceiver!=null){
            unregisterReceiver(offlineReceiver);
            offlineReceiver=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}