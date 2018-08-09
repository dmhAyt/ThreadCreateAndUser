package com.dmh.design.abastract;

/**
 * Created by deng_yt on 2018/8/8.
 */
public class CarFactory implements CarProduce {

  @Override
  public  Car getCar(String yourName, String carName) {
    Car car = null ;
    if("BYD".equals(carName)){
      car = new BYD();
    }else if("Audi".equals(carName)){
      car = new Audi();
    }
    return car;
  }
}
