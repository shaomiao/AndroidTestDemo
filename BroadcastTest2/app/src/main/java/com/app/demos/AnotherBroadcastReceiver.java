package com.app.demos;import android.content.BroadcastReceiver;import android.content.Context;import android.content.Intent;import android.widget.Toast;/** * Created by shaomiao on 2016-12-5. */public class AnotherBroadcastReceiver extends BroadcastReceiver {    @Override    public void onReceive(Context context, Intent intent) {        Toast.makeText(context, "received in AnotherBroadcastReceiver", Toast.LENGTH_SHORT).show();    }}