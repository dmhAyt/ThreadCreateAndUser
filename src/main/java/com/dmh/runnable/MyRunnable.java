package com.dmh.runnable;

/**
 * Created by deng_yt on 2018/8/7.
 */
public class MyRunnable implements Runnable {

  private String name = null;

  public MyRunnable() {

  }

  public MyRunnable(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(name+"  "+i);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
