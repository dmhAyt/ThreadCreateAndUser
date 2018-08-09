package com.dmh.design.singleton;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class SingletonMain {

  public static void main(String[] args) {
    DoubleClockSingleton dcs = DoubleClockSingleton.getInstance();
    DoubleClockSingleton dcs1 = DoubleClockSingleton.getInstance();

    System.out.println(dcs == dcs1);
    EnumSingleton e = EnumSingleton.getInstance();
    EnumSingleton e1 = EnumSingleton.getInstance();
    System.out.println(e == e1);


  }

}
