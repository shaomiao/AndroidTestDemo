package com.app.demos;import android.app.Activity;import android.os.Bundle;/** * Created by shaomiao on 2016-12-6. */public class BaseActivity extends Activity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        ActivityCollector.addActivity(this);    }    @Override    protected void onDestroy() {        super.onDestroy();        ActivityCollector.removeActivity(this);    }}