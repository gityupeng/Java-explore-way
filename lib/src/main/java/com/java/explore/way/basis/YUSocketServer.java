package com.java.explore.way.basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yu on 2017/4/27.
 * Socket 服务端
 */

public class YUSocketServer {

    public  static void accept(){
        //1创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口

        try {
        ServerSocket serverSocket = new ServerSocket(10086);//1024-65535的某个端口
        serverSocket.setSoTimeout(10000);
        //2调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        //3获取输入流，并读取客户端信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr =new InputStreamReader(is);
        BufferedReader br =new BufferedReader(isr);
        String info;

        while((info = br.readLine())!=null){
            System.out.println("Hello,我是服务器，客户端说："+info);
        }
        socket.shutdownInput(); //关闭输入流

        //4获取输出流，响应客户端的请求
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("你好，请问你想要啥！");
        pw.flush();
        //5关闭资源
        pw.close();
        os.close();
        br.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
        } catch (IOException io){
            io.printStackTrace();
        }

    }
}
