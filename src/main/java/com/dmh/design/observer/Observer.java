/**
 * Copyright (C), 2015-2018,
 * FileName: Observer
 * Author:   deng_yt
 * Date:     2018/8/15 12:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.design.observer;

/**
 * 观察者对象<br>
 * 定义了一个 update（） 方法，当被观察者调用 notifyO不server是（） 方法时，
 * 观察者的 update（） 方法会被回调
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
public interface Observer {
  void update(String  message);
}
