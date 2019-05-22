package com.wangzai.lovesy.demo2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wangzai.lovesy.demo2.ViewDemo.ViewActivity;
import com.wangzai.lovesy.demo2.customerview.CustomerViewActivity;
import com.wangzai.lovesy.demo2.profiler.ActivityOne;
import com.wangzai.lovesy.demo2.profiler.ActivityTwo;
import com.wangzai.lovesy.demo2.scroll.ScrollActivity;
import com.wangzai.lovesy.demo2.service.TestService;
import com.wangzai.lovesy.demo2.socket.SocketActivity;

public class MainActivity extends AppCompatActivity {

    public static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int flag = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            flag = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        decorView.setSystemUiVisibility(flag);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void clickButton1(View view) {
        Intent intent = new Intent(this, SocketActivity.class);
        startActivity(intent);
    }

    public void clickButton2(View view) {
        Intent intent = new Intent(this, TestService.class);
        startService(intent);
        Log.i("TAG111", "clickButton2");
    }

    public void clickButton3(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
        Log.i("TAG111", "clickButton3");
    }

    public void clickButton4(View view) {
        Intent intent = new Intent(this, ActivityOne.class);
        startActivity(intent);
        Log.i("TAG111", "clickButton4");
    }

    public void clickButton5(View view) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
        Log.i("TAG111", "clickButton5");
    }

    public void clickButton6(View view) {
//        Intent intent = new Intent(this, CustomerViewActivity.class);
        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
        Log.i("TAG111", "clickButton6");
    }
}
