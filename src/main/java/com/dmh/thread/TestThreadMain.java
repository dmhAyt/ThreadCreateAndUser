package com.dmh.thread;

/**
 * 使用继承 Thread 类的 线程方法
 * Created by deng_yt on 2018/8/7.
 */
public class TestThreadMain {

  public static void main(String[] args) {
    // 创建线程
    MyThread myThread = new MyThread();
    MyThread myThread1 = new MyThread();
    MyThread myThread2 = new MyThread();
    // 给线程创建名字
    myThread.setName("mythread 1 ");
    myThread1.setName("mythread 2 ");
    myThread2.setName("mythread 3 ");

    myThread.start();
    myThread1.start();
    myThread2.start();
  }
}
