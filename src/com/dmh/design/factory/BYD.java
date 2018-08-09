package com.dmh.design.factory;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class BYD implements Car{

  @Override
  public void driven() {
    System.out.println("BYD is driving in road!");
  }

  @Override
  public void color() {
    System.out.println("BYD is black!");
  }
}
