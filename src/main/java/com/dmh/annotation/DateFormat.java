package com.dmh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author deng_yt
 * @date  2018/8/9 22:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DateFormat {
  String dateFormat() default "yyyy-MM-dd hh:mm:ss a";
}
