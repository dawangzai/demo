package com.wangzai.lovesy.demo2.service;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class Guard1Service extends Service {

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("TAG111", "Guard1Service---onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("TAG111", "Guard1Service---onServiceDisconnected");

            Intent intent1 = new Intent(Guard1Service.this, TestService.class);
            startService(intent1);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG111", "Guard1Service---onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG111", "Guard1Service---onStartCommand");

        Intent intent1 = new Intent(this, TestService.class);
        bindService(intent1, connection, Context.BIND_AUTO_CREATE);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("TAG111", "Guard1Service---onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("TAG111", "Guard1Service---onUnbind");
        return super.onUnbind(intent);
    }
}
