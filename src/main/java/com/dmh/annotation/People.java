package com.dmh.annotation;

import java.util.Date;

/**
 * Created by deng_yt on 2018/8/9.
 */
public class People {

  private  String name;
  @DateFormat()
  private Date birthDay;

  public People() {
  }

  public People(String name, Date birthDay) {
    this.name = name;
    this.birthDay = birthDay;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }
}
