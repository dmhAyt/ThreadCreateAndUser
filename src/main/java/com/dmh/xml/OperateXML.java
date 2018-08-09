package com.dmh.xml;

import java.util.Iterator;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class OperateXML {
  public void createXMLFile(String file,String jsonStr){
    JSONObject json = JSONObject.fromObject(jsonStr);
    Document document = DocumentHelper.createDocument();
    System.out.println(json.keySet()+"     dd    ");
    Iterator keys = json.keys();
    String str = (String) keys.next();
    Element root = document.addElement(str);
    JSONArray jsons = json.getJSONArray(str);
    int jsonsLength = jsons.size();
    for (int i=0;i<jsonsLength;i++){
      JSONObject jsonObject  = (JSONObject) jsons.get(i);
      keys = json.keys();
      str = (String) keys.next();
      Element element = root.addElement(str);
      JSONArray forJsons = jsonObject.getJSONArray(str);
      for(int j = 0;j<forJsons.size();j++){
        JSONObject jsonObjectj  = (JSONObject) jsons.get(i);
        Iterator keysj = json.keys();
        String strj = (String) keysj.next();
        Element elementj = root.addElement(strj);
        elementj.addElement(strj);
        System.out.println(jsonObjectj.toString());
      }
    }
  }
}
