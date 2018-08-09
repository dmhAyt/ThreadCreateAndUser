package com.dmh.design.singleton;

/**
 * 懒汉式实现单例模式
 * Created by deng_yt on 2018/8/8.
 */
public class LazySingleton {
  private static LazySingleton instance = null;
  private LazySingleton(){}
  public synchronized static LazySingleton getInstance(){
    if(instance==null){
      instance = new LazySingleton();
    }
    return instance;
  }

}
