package com.dmh.design.singleton;

/**
 * 双重校验锁
 * Created by deng_yt on 2018/8/8.
 */
public class DoubleClockSingleton {
  private static DoubleClockSingleton instance = null;
  private DoubleClockSingleton(){}
  public static DoubleClockSingleton getInstance(){
    if(instance==null){
      synchronized (DoubleClockSingleton.class){
        if (instance == null){
          instance = new DoubleClockSingleton();
        }
      }
    }
    return instance;
  }

}
