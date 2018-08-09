package com.dmh.json;

import java.io.IOException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class JsonAndXMLTest extends TestCase {
  @Test
  public void test() throws IOException {
    JsonAndXML jax = new JsonAndXML();
    jax.jsonToXML("hello.json","test2.xml");
  }
  @Test
  public void testXmlToJson() throws IOException {
    JsonAndXML jax = new JsonAndXML();
    jax.xmlToJson("test1.xml","hello.json");
  }
}