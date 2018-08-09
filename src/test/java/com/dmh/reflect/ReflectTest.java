package com.dmh.reflect;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by deng_yt on 2018/8/9.
 */
public class ReflectTest extends TestCase {

  @Test
  public void testGetFieldValue() throws Exception {
    People p = new People();
    Reflect reflect = new Reflect();
    p.setName("yt");
    System.out.println(reflect.getFieldValue(p,"name"));
  }
  @Test
  public void testGetMethodResult() throws Exception {
    Reflect reflect = new Reflect();
    People p = new People();
    p.setName("yt");
    String[] str = {"dmh"};
    System.out.println(reflect.getMethodResult(p,"sayHello",str));
  }

}