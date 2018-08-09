#### 实现单例模式的方法（有5中方法）   
1. 懒汉式（LazySingleton）      
2. 饿汉式（HungrySingleton）     
3. 枚举（ENUMSingleton）（推荐）        
4. 内部静态类（InternalSingleton）（推荐）        
    在内部静态类方案中，对象的加载也是懒汉模式，使用内部类的classloader机制来保证线程安全性。在java虚拟机中，类的生命周期包括装载连接和初始化。jvm会保证对类的初始化过程被同步的进行。
5. 双重校验锁 （DoubleClockSingleton）