package com.yizhuo.learning.patterns.delegate;

/**
 * Created by yizhuo on 2018/5/29.
 */
public class CourierA implements ExpressDelivery{
    public void sendExpress(String sendto) {
        System.out.println("我是快递员A,正在向" + sendto + "发快递");
    }
}
