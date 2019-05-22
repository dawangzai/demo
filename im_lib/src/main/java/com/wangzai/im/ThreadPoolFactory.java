package com.wangzai.im;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFactory {

    private ExecutorService mWorkPool;

    private void initWorkPool() {
        destroyWorkPool();
        mWorkPool = Executors.newFixedThreadPool(1);
    }

    public void executeWorkThread(Runnable r) {
        if (mWorkPool == null) {
            initWorkPool();
        }
        mWorkPool.execute(r);
    }

    private void destroyWorkPool() {
        if (mWorkPool != null) {
            mWorkPool.shutdownNow();
            mWorkPool = null;
        }
    }
}
