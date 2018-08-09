package com.yt.thread;

import com.dmh.thread.MyThread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by deng_yt on 2018/8/7.
 */
public class MyThreadPoolExecutor {

  public static void main(String[] args) {
    ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(5));
    for (int i = 0; i < 15; i++) {
      MyThread myThread = new MyThread();
      myThread.setName("name " + i);
      tpe.execute(myThread);
    }
    System.out.println(
        tpe.getCorePoolSize() + " " + tpe.getActiveCount() + " " + tpe.getMaximumPoolSize() + " "
            + tpe.getPoolSize() + " " + tpe.getCompletedTaskCount() + " " + tpe.getTaskCount());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(
        tpe.getCorePoolSize() + " " + tpe.getActiveCount() + " " + tpe.getMaximumPoolSize() + " "
            + tpe.getPoolSize() + " " + tpe.getCompletedTaskCount() + " " + tpe.getTaskCount());

  }

}
