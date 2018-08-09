package com.dmh.reflect;

/**
 * Created by deng_yt on 2018/8/9.
 */
public class Animal {
  private int runSpeed = 5;

  public int getRunSpeed() {
    return runSpeed;
  }

  public void setRunSpeed(int runSpeed) {
    this.runSpeed = runSpeed;
  }
  public String  sayHello(String name){
    System.out.println("hello "+name);
    return "hello "+name + " return";
  }
}
