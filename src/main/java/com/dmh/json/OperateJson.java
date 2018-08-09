package com.dmh.json;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/**
 * Created by deng_yt on 2018/8/8.
 */
public class OperateJson {

  public String readJsonFile(String fileName) throws IOException {
    String result  = null;
    File file = new File(fileName);
    FileInputStream fis = null;
    Reader reader = null;
    BufferedReader br = null;

    if (file.exists()) {
      System.out.print("正在读取文件  ");
      try {
        fis = new FileInputStream(file);
        reader = new InputStreamReader(fis);
        br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String str = null;
        while ((str = br.readLine()) != null) {
          sb.append(str);
          str = null;
          System.out.print(".");
        }
        System.out.println();
        result = sb.toString();

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } finally {
        if (br != null) {
          br.close();
        }
        if (reader != null) {
          reader.close();
        }
        if (fis != null) {
          fis.close();
        }

      }
    } else {
      System.out.println("文件不存在！");
    }
    return result;
  }

  public void writerJsonFile(String fileName, String jsonData) throws IOException {
    File file = new File(fileName);
    FileOutputStream fos = null;
    OutputStreamWriter osw = null;
    BufferedWriter bw = null;
    if (file.exists()) {
    } else {
      try {
        System.out.println("正在创建文件。。。" + fileName);
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      System.out.println(jsonData);
      fos = new FileOutputStream(file);
      osw = new OutputStreamWriter(fos);
      bw = new BufferedWriter(osw);
      bw.write(jsonData);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (bw != null) {
        bw.close();
      }
      if (osw != null) {
        osw.close();
      }
      if (fos != null) {
        fos.close();
      }
    }


  }

}
