package com.dmh.design.builder;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class StudentMain {

  public static void main(String[] args) {
    Student st = new Student.StudentBuilder().setAge(1).setName("dmh").setSchool("haha").builder();
    System.out.println(st.toString());
  }

}
