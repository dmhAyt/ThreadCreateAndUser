package com.dmh.design.abastract;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class Audi implements Car {

  @Override
  public void color() {
    System.out.println("this is red");
  }

  @Override
  public void ownPeople(String name) {
    System.out.println("hi "+name+"! you own Audi");
  }
}
