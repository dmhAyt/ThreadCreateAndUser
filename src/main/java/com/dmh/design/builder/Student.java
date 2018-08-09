package com.dmh.design.builder;

/**
 * 建造者模式：表示当每个属性都能为空时，并且可以存在任意一个属性时，使用建造者模式，让你在构造函数上随意输入
 * Created by deng_yt on 2018/8/8.
 */
public class Student {
  private String name = null;
  private int number = -1;
  private String sex = null;
  private  int  age = -1;
  private String school = null;

  static class StudentBuilder{
    private String name = null;
    private int number = -1;
    private String sex = null;
    private  int  age = -1;
    private String school = null;

    public StudentBuilder setName(String name){
      this.name = name;
      return this;
    }
    public StudentBuilder setNumber(int number){
      this.number = number;
      return this;
    }
    public StudentBuilder setSex (String sex){
      this.sex = sex;
      return this;
    }
    public StudentBuilder setAge(int age){
      this.age = age;
      return this;
    }
    public StudentBuilder setSchool(String school){
      this.school = school;
      return this;
    }
    public  Student builder(){
      return new Student(this);
    }
  }
  private Student(StudentBuilder builder){
    this.age = builder.age;
    this.name = builder.name;
    this.number = builder.number;
    this.school = builder.school;
    this.sex = builder.sex;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", number=" + number +
        ", sex='" + sex + '\'' +
        ", age=" + age +
        ", school='" + school + '\'' +
        '}';
  }
}
