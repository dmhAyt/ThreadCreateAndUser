#### 有关线程的三种创建方法：    
+ 实现 Runnable 接口    
+ 实现 Callable 接口和使用 Future   
+ 继承 Thread 类    
**具体的在 com.dmh 下的 ThreadCreate.MD**   

#### 有关线程池的创建和参数     
+ 具体在 com.yt.thread 下的 线程池.MD 

#### 设计模式
 + com.dmh.design下    
1. 工厂模式
2. 抽象工厂模式
3. 单例模式
4. 建造者模式
5. 原型模式
 
#### 增加了json的从文件中读取，以及 json  读取后转为 xml 文件
* json 使用了 json-lib 架包，xml 使用了 dom4j 架包。
* **注意 JSONObeject.fromObeject(是String类型，StringBuffered不行)**
* json 在 com.dmh.json 包下， xml 在 com.dmh.xml 包下
=======
 
#### 将 maven 的 结构修改     
- 将原先的 jar 修改成 web 工程(也就是 war)      
- 调整了工程的目录结构（可以在项目结构中调整项目的结构，modules 中调整项目 test ，java 代码 资源等目录结构）    

