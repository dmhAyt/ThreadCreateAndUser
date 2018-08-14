package com.dmh.annotation;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 *  需求为：设计一个注解，标注属性，表示日期的格式 如 yyyy-MM-dd HH:mm;ss
 * Created by deng_yt on 2018/8/9.
 */
public class AnnotationMain {

/** 
 *  描述
 * @author deng_yt 
 * @date  2018/8/9 21:52 
 * @param  args
 * @return
 */
  public static void main(String[] args) throws NoSuchFieldException {
    People people = new People("dmh",new Date());

    // 这里获得所标注的注解。
    Field[] birthDay = people.getClass().getDeclaredFields();
    DateFormat annotation = null;
    for (Field field:birthDay) {
      annotation = field.getAnnotation(DateFormat.class);
      if(annotation!=null){
        break;
      }
    }
    // annotation.md.dateFormat() 获得相应的注解中的值。 如果是默认的就是 (yyyy-MM-dd hh:mm:ss a)
    System.out.println(annotation.dateFormat());
    System.out.println(people.getBirthDay().toString());
    // 国际化日期
    SimpleDateFormat sdf = new SimpleDateFormat(annotation.dateFormat());
    System.out.println(sdf.format(people.getBirthDay()));

  }

}
