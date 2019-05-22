package com.wangzai.lovesy.demo2.socket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wangzai.im.protobuf.MessageProtobuf;
import com.wangzai.lovesy.demo2.R;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

public class SocketActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingleMessage message = new SingleMessage();
        message.setMsgId(UUID.randomUUID().toString());
        message.setMsgType(3000);
        message.setMsgContentType(102);
        message.setFromId("fromid");
        message.setToId("12");
        message.setTimestamp(System.currentTimeMillis());
        message.setExtend("extend");
        message.setContent("你好");

        MessageProtobuf.Msg msg = getProtoBufMessageBuilderByAppMessage(buildAppMessage(message)).build();
        final byte[] bytes = msg.toByteArray();
        Log.i("TAG", new String(bytes));
        new Thread(new Runnable() {
            @Override
            public void run() {
                ByteArrayInputStream is = null;
                try {
                    is = new ByteArrayInputStream(bytes);
                    byte[] buf = new byte[1];
                    while (is.read(buf) != -1) {
                        Log.i(TAG, new String(buf,"UTF-8"));
                    }
                } catch (IOException e) {

                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();

    }

    public MessageProtobuf.Msg.Builder getProtoBufMessageBuilderByAppMessage(AppMessage message) {
        MessageProtobuf.Msg.Builder builder = MessageProtobuf.Msg.newBuilder();
        MessageProtobuf.Head.Builder headBuilder = MessageProtobuf.Head.newBuilder();
        headBuilder.setMsgType(message.getHead().getMsgType());
        headBuilder.setStatusReport(message.getHead().getStatusReport());
        headBuilder.setMsgContentType(message.getHead().getMsgContentType());
        headBuilder.setMsgId(message.getHead().getMsgId());
        headBuilder.setFromId(message.getHead().getFromId());
        headBuilder.setToId(message.getHead().getToId());
        headBuilder.setTimestamp(message.getHead().getTimestamp());
        headBuilder.setExtend(message.getHead().getExtend());
        builder.setBody(message.getBody());
        builder.setHead(headBuilder);
        return builder;
    }

    public static AppMessage buildAppMessage(BaseMessage msg) {
        AppMessage message = new AppMessage();
        Head head = new Head();
        head.setMsgId(msg.getMsgId());
        head.setMsgType(msg.getMsgType());
        head.setMsgContentType(msg.getMsgContentType());
        head.setFromId(msg.getFromId());
        head.setToId(msg.getToId());
        head.setExtend(msg.getExtend());
        head.setTimestamp(msg.getTimestamp());
        message.setHead(head);
        message.setBody(msg.getContent());

        return message;
    }
}
