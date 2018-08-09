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
     String jsonStr =  oj.readJsonFile("hello.json");
      System.out.println(jsonStr);
     JSONObject jsonObject = JSONObject.fromObject(jsonStr);
      JSONArray json = (JSONArray) jsonObject.get("组别");
      //================
      Document document = DocumentHelper.createDocument();
      Element root = document.addElement("组别");

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
          Element element = el.addElement("人");
          element.addAttribute("id",j+"");
          JSONObject jos = jo.getJSONObject("人");
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
    json1.put("name","dmh");
    json1.put("number","12345");
    json1.put("department","中台");

    JSONObject json2 = new JSONObject(false);
    json2.put("name","dmh1");
    json2.put("number","12346");
    json2.put("department","中台");
    JSONArray array = new JSONArray();
    people.put("人",json1);
    array.add(people);
    people.put("人",json2);
    array.add(people);
    JSONObject zu1= new JSONObject(false);
    zu1.put("华东一组",array);
    //----------------------------------------------------
    json1.put("name","dmh3");
    json1.put("number","12347");
    json1.put("department","中台");
    json2.put("name","dmh4");
    json2.put("number","12348");
    json2.put("department","中台");
    array = new JSONArray();

    people.put("人",json1);
    array.add(people);
    people.put("人",json2);
    array.add(people);
    JSONObject zu2= new JSONObject(false);
    zu2.put("华东二组",array);

    JSONArray erea = new JSONArray();
    erea.add(zu1);
    erea.add(zu2);
    JSONObject totall = new JSONObject(false);
    totall.put("组别",erea);

    try {
      oj.writerJsonFile("hello.json",totall.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}