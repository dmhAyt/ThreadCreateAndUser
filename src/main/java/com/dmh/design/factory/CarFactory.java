package com.dmh.design.factory;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class CarFactory {
  private CarFactory(){}

  public static BYD getBYD() {
    return new BYD();
  }

  public static Audi getAudi() {
    return new Audi();
  }
}
