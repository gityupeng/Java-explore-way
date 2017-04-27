package com.java.explore.way.basis.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by yu on 2017/4/27.
 * Socket 客户端类
 */

public class YuSocketClient {

    public static void connectServer(String ip,int port){

        try {
            //1、创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket(ip, port);
            socket.setSoTimeout(5000);
            //2、获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
            pw.write("用户名：admin；密码：admin");
            pw.flush();
            socket.shutdownOutput();

            //3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info;
            while ((info = br.readLine()) !=null){
                System.out.println("Hello,我是客户端，服务器说：" + info);
            }

            //4、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException io){
            io.printStackTrace();
        }

    }

}