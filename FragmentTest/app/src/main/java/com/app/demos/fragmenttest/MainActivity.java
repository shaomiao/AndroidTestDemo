package com.app.demos.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                //动态加载布局

                // 创建待添加的碎片实例
                AnotherRightFragment fragment = new AnotherRightFragment();
                // 获取FragmentManager，在活动中可以直接调用getFragmentManager()方法得到
                FragmentManager fragmentManager = getFragmentManager();
                // 开启一个事务调用通过调用beginTransaction()方法开启
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                // 向容器加入碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例。
                transaction.replace(R.id.right_layout, fragment);

                // 可以用于将一 个事务添加到返回栈中
                transaction.addToBackStack(null);

                // 提交事务，调用commit()方法来实现
                transaction.commit();
                break;
            default:
                break;
        }
    }
}
