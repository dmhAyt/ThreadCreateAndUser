package com.dmh.design.singleton;

/**
 * 枚举实现单例模式。（推荐，因为枚举本来就是线程安全的）
 * Created by deng_yt on 2018/8/8.
 */
public enum EnumSingleton {
   INSTANCE;
  public static EnumSingleton getInstance(){
    return INSTANCE;
  }
}
