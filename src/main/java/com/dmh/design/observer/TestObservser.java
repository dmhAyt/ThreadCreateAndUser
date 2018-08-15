/**
 * Copyright (C), 2015-2018,
 * FileName: TestObservser
 * Author:   deng_yt
 * Date:     2018/8/15 12:53
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
public class TestObservser {

  public static void main(String[] args) {
    WechatServer ws = new WechatServer();
    User u = new User();
    ws.registerObserver(u);
//    ws.removeObserver(u);
    ws.setInformation("he1lo 这是观察者模式");
  }
}
