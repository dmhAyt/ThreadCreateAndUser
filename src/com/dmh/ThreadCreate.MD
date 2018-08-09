#### 创建线程的三种方式   
* 通过实现 Runnable 接口   
   重写 run 方法
* 通过继承 Thread 类本事     
   重写 run 方法
* 通过 Callable 和 FutureTask 创建线程（带返回值的）   
   重写 call 方法，并且带有返回值，使用 FutureTask = new FutureTask(Callable_impl_obj);
        
        
#### 创建线程的三种方式对比    
* 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。      
* 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 关键字即可获得当前线程    

[菜鸟教程](http://www.runoob.com/java/java-multithreading.html)    
[博客](https://www.cnblogs.com/wxd0108/p/5479442.html) // 还未看
