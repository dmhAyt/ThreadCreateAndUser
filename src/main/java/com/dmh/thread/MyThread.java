package com.dmh.thread;

/**
 * 第一种实现多线程的方法 继承 Thread 类，重写 run 方法，业务逻辑放在 run 方法中，注意线程安全问题。
 * 但是本质上还是实现了 Runnable 接口
 * Created by deng_yt on 2018/8/7.
 */
public class MyThread extends Thread {
  private static int num = 0;
  @Override
  public void run() {
    for (int i = 0 ;i<10;i++){
        num++;
      System.out.println(this.getName()+"  "+num);
      if(this.getName().equals("mythread 2 ")){
        System.out.println(this.getId()+"  "+this.getPriority()+" "+this.getContextClassLoader()+" " + this.getState()+" "+this.getThreadGroup());
        System.out.println(this.isAlive()+" "+this.isDaemon()+" "+this.isInterrupted());
      }
      try {
        sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
