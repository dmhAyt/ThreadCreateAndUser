package com.dmh.json;


import com.dmh.xml.OperateXML;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class OperateJsonTest extends TestCase {
  @Test
  public void test(){
    OperateJson oj = new OperateJson();
    try {
     String jsonStr =  oj.readJsonFile("hello1.json");
      System.out.println(jsonStr);
     JSONObject jsonObject = JSONObject.fromObject(jsonStr);
      JSONArray json = (JSONArray) jsonObject.get("读物");
      //================
      Document document = DocumentHelper.createDocument();
      Element root = document.addElement("读物");

      System.out.println(json.isArray());
      int jsonlength = json.size();
      for (int i = 0; i <jsonlength ; i++) {
        JSONObject array = (JSONObject) json.get(i);
        Iterator keys = array.keys();
        String name = (String) keys.next();
        System.out.println(array.toString());
        System.out.println("name "+name);
        //======================
        Element el = root.addElement(name);

        JSONArray jsonArray = array.getJSONArray(name);
        int arrrayLength = jsonArray.size();
        for (int j = 0; j <arrrayLength ; j++) {
          JSONObject jo = jsonArray.getJSONObject(j);
          System.out.println(jo.toString());
          Element element = el.addElement("书本");
          element.addAttribute("id",j+"");
          JSONObject jos = jo.getJSONObject("书本");
          System.out.println(jos.toString());
          Iterator keys1 = jos.keys();
          while (keys1.hasNext()) {
            String names = (String) keys1.next();
            System.out.println(names+" = "+jos.getString(names));
            Element element1 = element.addElement(names);
            element1.addText(jos.getString(names));
          }
        }
      }
      File file = new File("test.xml");
      FileOutputStream fos = new FileOutputStream(file);
     OutputStreamWriter foss = new OutputStreamWriter(fos);
      BufferedWriter bw = new BufferedWriter(foss);
      document.write(bw);



      bw.close();
      foss.close();
      fos.close();


      OperateXML oxml = new OperateXML();
     // oxml.createXMLFile("hello.xml",jsonStr);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test2(){
    JSONObject jo = new JSONObject(false);
    jo.put("name","dmh2");
    jo.put("pass","dmhpass");
    jo.put("sex","1");
    System.out.println(jo.toString());
    String string = "{\"name\":\"dmh9\",\"pass\":\"dmhpass\",\"sex\":\"1\"}";
    System.out.println(string+ "   st");
    JSONObject jos = JSONObject.fromObject(string);
    System.out.println(jos.get("name"));
    OperateJson op = new OperateJson();
    try {
      op.writerJsonFile("hello.json",jos.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void test1(){
    OperateJson oj = new OperateJson();
    JSONObject json1 = new JSONObject(false);
    JSONObject people = new JSONObject(false);
    json1.put("name","活着");
    json1.put("author","余华");
    json1.put("price","55");

    JSONObject json2 = new JSONObject(false);
    json2.put("name","平凡的世界");
    json2.put("author","路遥");
    json2.put("price","120");
    JSONArray array = new JSONArray();
    people.put("书本",json1);
    array.add(people);
    people.put("书本",json2);
    array.add(people);
    JSONObject zu1= new JSONObject(false);
    zu1.put("小说",array);
    //----------------------------------------------------
    json1.put("name","红楼梦");
    json1.put("author","曹雪芹");
    json1.put("price","88");
    json2.put("name","三国演义");
    json2.put("author","罗贯中");
    json2.put("price","88");
    array = new JSONArray();

    people.put("书本",json1);
    array.add(people);
    people.put("书本",json2);
    array.add(people);
    JSONObject zu2= new JSONObject(false);
    zu2.put("名著",array);

    JSONArray erea = new JSONArray();
    erea.add(zu1);
    erea.add(zu2);
    JSONObject totall = new JSONObject(false);
    totall.put("读物",erea);

    try {
      oj.writerJsonFile("hello1.json",totall.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}