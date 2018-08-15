/**
 * Copyright (C), 2015-2018,
 * FileName: WechatServer
 * Author:   deng_yt
 * Date:     2018/8/15 12:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dmh.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author deng_yt
 * @create 2018/8/15
 * @since 1.0.0
 */
public class WechatServer implements  Observerable {

  private List<Observer> list;
  private String message;

  public WechatServer() {
    this.list = new ArrayList<Observer>();
  }

  @Override
  public void registerObserver(Observer o) {
    list.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    if(!list.isEmpty()){
      list.remove(o);
    }
  }

  @Override
  public void notifyObserver() {
    for (Observer o:list){
      o.update(message);
    }
  }

  public void setInformation(String message){
    this.message = message;
    System.out.println("服务更新消息： "+message);
    notifyObserver();
  }

}
