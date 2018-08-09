package com.dmh.design.factory;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class FactoryMain {

  public static void main(String[] args) {
    BYD byd = CarFactory.getBYD();
    byd.driven();
    byd.color();
    System.out.println("-----------------------");
    Audi audi = CarFactory.getAudi();
    audi.color();
    audi.driven();

  }
}
