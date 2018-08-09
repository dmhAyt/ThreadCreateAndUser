package com.dmh.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by deng_yt on 2018/8/7.
 */
public class MyCallableMain {

  public static void main(String[] args) {
    MyCallable test1 = new MyCallable("test1");
    MyCallable test2 = new MyCallable("test2");
    MyCallable test3 = new MyCallable("test3");

    FutureTask<String> f1 = new FutureTask<String>(test1);
    FutureTask<String> f2 = new FutureTask<String>(test2);
    FutureTask<String> f3 = new FutureTask<String>(test3);

//    f1.run();
    new Thread(f1,"kkk").start();
    f2.run();
    f3.run();

    try {
      System.out.println(f1.get());
      System.out.println(f2.get());
      System.out.println(f3.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

  }
}
