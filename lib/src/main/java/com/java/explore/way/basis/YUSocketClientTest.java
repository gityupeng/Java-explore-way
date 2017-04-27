package com.java.explore.way.basis;

/**
 * Created by yu on 2017/4/27.
 */

public class YUSocketClientTest {

    public static void main(String [] args){

        YuSocketClient socketClient = new YuSocketClient();
        YuSocketClient.connectServer("127.0.0.1",10086);

    }
}
