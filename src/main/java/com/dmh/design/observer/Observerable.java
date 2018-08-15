/**
 * Copyright (C), 2015-2018,
 * FileName: Observerable
 * Author:   deng_yt
 * Date:     2018/8/15 12:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.design.observer;

/**
 *  这个是被观察者对象<br>
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
public interface Observerable {

  void registerObserver(Observer o);
  void removeObserver(Observer o);
  void notifyObserver();

}
