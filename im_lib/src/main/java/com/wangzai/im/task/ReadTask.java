package com.wangzai.im.task;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadTask implements Runnable {

    private boolean isReadStop = false;
    private InputStream mIs;
    private byte[] tag = new byte[]{'_', 'a', 'c', 'd'};

    private ReadTask(InputStream is) {
        this.mIs = is;
    }

    public static void create(InputStream is) {
        new ReadTask(is);
    }

    @Override
    public void run() {

        while (!isReadStop) {
            byte[] currentTag = new byte[4];
            try {
                int read = mIs.read(currentTag, 0, currentTag.length);
                check(read);
                if (Arrays.equals(currentTag,tag)){
                    // 开始读数据

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void check(int status){
        if (status == -1){

        }
    }

    private void readStop() {
        isReadStop = true;
    }
}
