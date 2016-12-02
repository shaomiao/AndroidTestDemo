package com.app.demos.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /**
         * 根据 Android的规定，在 160dpi的屏幕上，1dp等于 1px，而在 320dpi的屏幕上，1dp 就等于 2px。
         * 因此，使用 dp来指定控件的宽和高，就可以保证控件在不同密度的屏幕中的 显示比例保持一致。
         */
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.d("MainActivity", "xdpi is " + xdpi);
        Log.d("MainActivity", "ydpi is " + ydpi);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, MenuActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, FirstActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, FruitActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, MsgActivity.class));
                break;
        }
    }
}
