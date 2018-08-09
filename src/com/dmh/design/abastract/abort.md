#### 抽象工厂（Abastract Factory）     
  是对 factory 的补充，因为 factory 新增一个 car 的实现类就必须修改 carFactory，而 抽象工厂就将实现类和工厂解耦
  通过一个产品接口（carProduce），工厂只需要实现这个接口就可以创建对应想要创建的产品了。
  
#### 步骤    
1. 创建一个父接口 如例子中的 Car      
2. 实现父接口 如例子中的 BYD、Audi   
3. 创建一个产品接口 如例子中的 CarProduce     
4. 创建实现产品接口的实现类 如例子中的 CarFactory （这里可以是多个）
