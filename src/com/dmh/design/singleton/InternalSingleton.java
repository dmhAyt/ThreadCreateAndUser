package com.dmh.design.singleton;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * 内部静态了的方法（推荐）
 * Created by deng_yt on 2018/8/8.
 */
public class InternalSingleton {

  private static class InternalSingletonHolder {

    private static final InternalSingleton INSTANCE = new InternalSingleton();
  }

  private InternalSingleton() {
  }

  public static InternalSingleton getInstance() {
    return InternalSingletonHolder.INSTANCE;
  }

}
