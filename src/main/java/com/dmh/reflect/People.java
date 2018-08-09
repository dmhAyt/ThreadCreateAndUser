package com.dmh.reflect;

/**
 * Created by deng_yt on 2018/8/9.
 */
public class People extends Animal{
  private String name = "dmh";
  private int age = 23;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
