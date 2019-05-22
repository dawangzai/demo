package com.wangzai.lovesy.demo2.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class TestService extends Service {

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("TAG111", "TestService---onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("TAG111", "TestService---onServiceDisconnected");
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG111", "TestService---onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG111", "TestService---onStartCommand");

        Intent intent1 = new Intent(this, Guard1Service.class);
        startService(intent1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("TAG111", "TestService---onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i("TAG111", "TestService---onDestroy");
        super.onDestroy();
    }
}
