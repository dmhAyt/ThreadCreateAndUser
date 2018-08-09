package com.dmh.design.protype;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class StudentMain {

  public static void main(String[] args) throws CloneNotSupportedException {
    Student st = new Student("dmh");
    System.out.println(st.toString());
    System.out.println("====");
    Student st2 = st.clone();
    System.out.println("st2 " + st2.toString());
    System.out.println(st == st2);
  }

}
