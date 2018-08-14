#### 注解的定义就必须使用的反射。     
* 新建注解 public @interface annotation_name { String dateFormat() default "yyyy-MM-dd"  }    
   其实注解就是一个接口类只不过是加了一个@      
+ 元注解：(就是使用在注解上的注解)       
   * @Retention 表示注解的存活期为多长。取值如下     
     **RetentionPolicy.SOURCE** 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽略。        
     **RetentionPolicy.CLASS**  注解只被保留到编译进行的时候，它并不会被加载进入到 JVM 中。      
     **RetentionPolicy.RUNTIME**  注解可以保留到程序运行的时候，它会被加载到 JVM 中，所以在程序运行时可以获取到它们。
   * @Target 表示注解作用的对象（比如类或者属性。。。。）取值如下：          
     **ElementType.ANNOTATION_TYPE** 可以给一个注解进行注解             
     **ElementType. CONSTRUCTOR**   可以给构造方法进行注解                
     **ElementType.FIELD**     可以给属性进行注解                   
     **ElementType.LOCAL_VARIABLE**   可以给局部变量进行注解              
     **ElementType.METHOD**    可以给方法进行注解                   
     **ElementType.PACKAGE**   可以给一个包进行注解               
     **ElementType.PARAMETER**   可以给一个方法内的参数进行注解                 
     **ElementType.TYPE**    可以给一个类型进行注解，比如类、接口、枚举               
   * @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解           
   * @Repeatable Repeatable 自然是可以重复的意思。 java 1.8 才加进来的。