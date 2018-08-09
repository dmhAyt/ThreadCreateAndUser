package com.dmh.callable;

import com.dmh.runnable.MyRunnable;
import java.util.concurrent.Callable;

/**
 * 通过 callable 和 futureTask 创建线程
 *  1 创建 Callable 接口的实现类，并实现 call() 方法，该方法将作为线程执行体，并且有返回值。
 * Created by deng_yt on 2018/8/7.
 */
public class MyCallable implements Callable<String> {

  private String name = null;

  public MyCallable(String name) {
    this.name = name;
  }

  @Override
  public String call() throws Exception {
    for (int i = 0; i < 10; i++) {
      System.out.println(name + " " + i);
      Thread.sleep(100);
    }
    return name + " is over !";
  }
}
