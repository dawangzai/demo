package com.wangzai.im.interf;

import com.wangzai.im.protobuf.MessageProtobuf;

public interface IClientInterface {

    void init();

    void resetConnect();

    void sendMsg(MessageProtobuf.Msg msg);
}
