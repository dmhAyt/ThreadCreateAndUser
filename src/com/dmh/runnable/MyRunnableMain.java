package com.dmh.runnable;

/**
 * Created by deng_yt on 2018/8/7.
 */
public class MyRunnableMain {

  public static void main(String[] args) {
    MyRunnable mr1 = new MyRunnable("test1");
    MyRunnable mr2 = new MyRunnable("test2");
    MyRunnable mr3 = new MyRunnable("test3");

    Thread t1 = new Thread(mr1);
    Thread t2 = new Thread(mr2);
    Thread t3 = new Thread(mr3);

    t1.start();
    t2.start();
    t3.start();
    System.out.println(t1.getName()+" "+t2.getName()+" "+t3.getName());

  }

}
