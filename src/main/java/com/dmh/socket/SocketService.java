/**
 * Copyright (C), 2015-2018,
 * FileName: SocketService
 * Author:   deng_yt
 * Date:     2018/8/10 10:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImplFactory;

/**
 * 实现 socket 通信的服务端，这种可以使用 点对点通信。
 *
 * @author deng_yt
 * @create 2018/8/10
 * @since 1.0.0
 */
public class SocketService {
  private static final int PORT = 10800;
  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(PORT);
      System.out.println("我正在等待。。。。");
      Socket accept = serverSocket.accept();
      System.out.println(accept.getInetAddress()+" "+accept.getKeepAlive()+" "+accept.getLocalPort());
      InputStream inputStream = accept.getInputStream();
      InputStreamReader isr = new InputStreamReader(inputStream);
      BufferedReader br  = new BufferedReader(isr);
      StringBuffer sb = new StringBuffer();
      String str = null;
      while ((str=br.readLine())!=null){
        sb.append(str);
      }
      System.out.println(sb);



      OutputStream outputStream = accept.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(outputStream);
      BufferedWriter bw = new BufferedWriter(osw);

      bw.write("a accept your request! i'm service "+serverSocket.getLocalPort());
      bw.flush();
      accept.shutdownOutput();

      br.close();
      isr.close();
      inputStream.close();
      bw.close();
      osw.close();
      outputStream.close();
      accept.close();

    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      if(serverSocket!=null){
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
