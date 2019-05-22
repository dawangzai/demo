package com.wangzai.im;

import com.wangzai.im.interf.IClientInterface;
import com.wangzai.im.protobuf.MessageProtobuf;

import java.net.Socket;

public class SocketClient implements IClientInterface {
    private Socket mSocket;

    @Override
    public void init() {

    }

    @Override
    public void resetConnect() {

    }

    @Override
    public void sendMsg(MessageProtobuf.Msg msg) {

    }
}
