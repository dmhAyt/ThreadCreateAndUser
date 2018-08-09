package com.dmh.design.abastract;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class AbastractFactoryMain {

  public static void main(String[] args) {
    CarFactory cf = new CarFactory();
    BYD byd = (BYD) cf.getCar("dmh", "BYD");
    byd.color();
    byd.ownPeople("dmh");
    System.out.println("-------------");
    Audi audi = (Audi) cf.getCar("yt", "Audi");
    audi.color();
    audi.ownPeople("yt");
  }

}
