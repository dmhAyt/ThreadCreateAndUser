package com.dmh.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by deng_yt on 2018/8/10.
 */
public class SocketServiceTest extends TestCase {

  @Test
  public void test() throws IOException {
    Socket socket = new Socket("localhost", 10800);
    if (socket.isConnected()) {
      OutputStream outputStream = socket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(outputStream);
      BufferedWriter bw = new BufferedWriter(osw);
      bw.write("hi i have a request");
      bw.flush();
      socket.shutdownOutput();

      while (1 == 1) {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        String str = null;
        while ((str = br.readLine()) != null) {
          sb.append(str);
        }
        System.out.println(sb);
        bw.close();
        osw.close();
        outputStream.close();
        br.close();
        isr.close();
        inputStream.close();
        if (socket.isClosed()) {
          break;
        }
      }
      socket.close();
    }
  }
}