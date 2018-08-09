package com.dmh.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class JsonAndXML {

  public String jsonToXML(String jsonFileName,String goalFile) throws IOException {
    String dataStr = null;
    File file = new File(jsonFileName);
    String fileName = file.getName();
    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
    if ("JSON".equals(suffix.toUpperCase())) {
      dataStr = getDataFromFile(jsonFileName);
      // 转为 json 对象。

      JSONObject jsonObject = JSONObject.fromObject(dataStr);
      if (jsonObject != null) {
        System.out.println(jsonObject.toString());
        String s = jsonComeToXml(jsonObject,goalFile);
      } else {
        return null;
      }
    }else{
      return null;
    }
    return null;
  }
  public String xmlToJson(String xmlFileName){

    return null;
  }


  private String getDataFromFile(String fileName) throws IOException {
    File file = new File(fileName);
    FileInputStream fis = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    StringBuffer jsonStr = new StringBuffer();
    try {
      // 读取 json 文件
      fis = new FileInputStream(file);
      isr = new InputStreamReader(fis);
      br = new BufferedReader(isr);
      String str = null;
      while ((str = br.readLine()) != null) {
        jsonStr.append(str);
      }
      // 得到文件中的数据

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      br.close();
      isr.close();
      fis.close();
    }
    return jsonStr.toString();
  }
  private String jsonComeToXml(JSONObject jsonObject,String goalFile) throws IOException {
    Document document = DocumentHelper.createDocument();
    Iterator rootName = jsonObject.keys();
    String rootNameStr = (String) rootName.next();
    Element root = document.addElement(rootNameStr);
    document.setRootElement(root);
    JSON  json = (JSON) jsonObject.get(rootNameStr);
    creatElement(root,json);

    File file = new File(goalFile);
    FileOutputStream fos = new FileOutputStream(file);
    OutputStreamWriter osw = new OutputStreamWriter(fos);

    document.setXMLEncoding("utf-8");
    document.write(osw);

    osw.close();
    fos.close();

    return null;
  }
  private void creatElement(Element element,JSON json){
    // 获得根节点名字
    if(json.isArray()){
      int length = json.size();
      System.out.println("是数组");
      for (int i = 0;i<length;i++){
        System.out.println(i);
        JSONArray jsonArray = (JSONArray) json;
        JSON jsons = (JSON) jsonArray.get(i);
        creatElement(element,jsons);
      }
    }else{
      // 不是数组，那么就看开始写。
      JSONObject jsonObject = (JSONObject) json;
      Iterator keys = jsonObject.keys();
      while (keys.hasNext()){
        String name = (String) keys.next();
        System.out.println(name);
        Element element1 = element.addElement(name);
        JSON jsons = (JSON) jsonObject.get(name);
        if(jsons.isArray()){
          creatElement(element1,jsons);
        }else if(jsons.isEmpty()){
          element1.addText(jsonObject.getString(name));
        }else{
         JSONObject jo = (JSONObject) jsons;
          Iterator keys1 = jo.keys();
          while (keys1.hasNext()){
            String names = (String) keys1.next();
            Element element2 = element1.addElement(names);
            element2.addText(jo.getString(names));
          }
        }
      }
    }
  }
}
