/**
 * Copyright (C), 2015-2018,
 * FileName: User
 * Author:   deng_yt
 * Date:     2018/8/15 12:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.design.observer;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
public class User implements Observer {

  @Override
  public void update(String message) {
    System.out.println("user "+message);
  }
}
