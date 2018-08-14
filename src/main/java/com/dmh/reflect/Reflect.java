package com.dmh.reflect;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 需求：传入两个参数，一个参数为对象，另外一个参数为对象的属性，这个属性可能在对象中，也可能在对象的父类的中
 * Created by deng_yt on 2018/8/9.
 */
public class Reflect {

  private static final String FIELD = "FIELD";
  private static final String METHOD = "METHOD";

  /**
   *  描述:
   * @author deng_yt
   * @date  2018/8/9 22:02
   * @param className
   * @param fieldName
   * @return
   */
  public Object getFieldValue(Object className, String fieldName)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
    Object str = null;
    Field field = (Field) getFieldOrMethod(className.getClass(), fieldName, FIELD);
    if (field != null) {
      field.setAccessible(true);
      str = field.get(className);
    }
    return str;
  }

  public Object getMethodResult(Object className, String methodName, Object[] methodParameter)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
    Object str = null;
    Method method = (Method) getFieldOrMethod(className.getClass(), methodName, METHOD);
    if (method != null) {
      str = method.invoke(className, methodParameter);
    }
    return str;
  }

  /**
   * 查找对应的属性或者方法在指定的类和父类中
   *
   * @param cla 对应的的实例 Class
   * @param name 方法或者属性名称
   * @param flag 标记，查找的是方法还是属性
   * @return 返回对应找到的值
   */
  private Object getFieldOrMethod(Class cla, String name, String flag)
      throws IllegalAccessException, InstantiationException, InvocationTargetException {
    Object result = null;
    // true 表示在本类中没用找到,false 表示在本类中找到了
    boolean flagB = true;
    if (FIELD.equals(flag)) {
      Field[] declaredFields = cla.getDeclaredFields();
      for (Field field : declaredFields) {
        if (name.equals(field.getName())) {
          // 找到了，结束
          result = field;
          flagB = false;
          break;
        }
      }
      // 本次没有找到，看看父类中是否存在
      if (flagB) {
        Class superclass = cla.getSuperclass();
        if (superclass != null) {
          result = getFieldOrMethod(superclass, name, flag);
        } else {
          // 没有父类 结束吧孩子
        }
      }
    } else if (METHOD.equals(flag)) {
      // 获得本类中的所有方法
      Method[] methods = cla.getDeclaredMethods();
      for (Method method : methods) {
        if (name.equals(method.getName())) {
          // 找到了
          result = method;
          flagB = false;
          break;
        }
      }
      if (flagB) {
        // 真难受没有啊
        Class superclass = cla.getSuperclass();
        if (superclass != null) {
          result = getFieldOrMethod(superclass, name, flag);
        } else {
          // 没有父类 结束吧孩子
        }
      }
    } else {

    }
    return result;
  }

}
