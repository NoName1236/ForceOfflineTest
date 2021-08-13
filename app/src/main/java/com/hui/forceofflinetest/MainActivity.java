package com.hui.forceofflinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private IntentFilter intentFilter;
    private MyBroadcastReceiver mbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button force_offline_btn=findViewById(R.id.force_offline);
        force_offline_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.hui.forceofflinetest.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

//        initReceiver();
    }

    private void initReceiver() {
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_USER_PRESENT);
        mbr=new MyBroadcastReceiver();
        this.registerReceiver(mbr,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mbr);
    }
}