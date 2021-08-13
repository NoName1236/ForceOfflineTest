package com.hui.forceofflinetest;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Warning").setMessage("You are forced to offline.Please try to login again").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishAll();
                Intent intent1 = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });
        builder.show();
    }
}
