package com.dmh.design.abastract;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class BYD implements Car {

  @Override
  public void color() {
    System.out.println("BYD is blue");
  }

  @Override
  public void ownPeople(String name) {
    System.out.println("hi "+name+"! you own BYD");
  }
}
