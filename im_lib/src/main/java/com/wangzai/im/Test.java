package com.wangzai.im;

import java.io.IOException;
import java.net.ServerSocket;

public class Test {

    public void test() throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        serverSocket.accept();
    }
}
