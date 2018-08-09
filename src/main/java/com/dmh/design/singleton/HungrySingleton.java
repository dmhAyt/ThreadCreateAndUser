package com.dmh.design.singleton;

/**
 * 饿汉式实现单例模式
 * Created by deng_yt on 2018/8/8.
 */
public class HungrySingleton {
  private  static HungrySingleton instance = new HungrySingleton();
  private HungrySingleton(){}
  public static HungrySingleton getInstance(){
    return instance;
  }
}
