package com.zhuo.designpatterns.structural.proxy.sample2.jdk;

import com.zhuo.designpatterns.structural.proxy.sample2.Person;

/**
 * Created by yizhuo on 2018/5/6.
 */
public class Zhangsan implements Person {


    public void findHouse() {
        System.out.println("张三需要找房子.");
    }

    public void findLove() {
        System.out.println("找对象");
        System.out.println("肤白貌美 大长腿");
    }
}
