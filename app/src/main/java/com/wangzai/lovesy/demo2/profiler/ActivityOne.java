package com.wangzai.lovesy.demo2.profiler;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ActivityOne.this, "ActivityOne", Toast.LENGTH_SHORT).show();
            }
        }, 1000 * 1000);
    }
}
