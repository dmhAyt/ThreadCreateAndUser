package com.dmh.design.protype;

/**
 * 原型模式
 * Created by deng_yt on 2018/8/8.
 */
public class Student implements Cloneable {
  private String name;

  public Student(String name) {
    this.name = name;
  }

  @Override
  protected Student clone() throws CloneNotSupportedException {
    return (Student) super.clone();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        '}';
  }
}
