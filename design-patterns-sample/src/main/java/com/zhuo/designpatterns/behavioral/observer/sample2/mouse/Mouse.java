package com.zhuo.designpatterns.behavioral.observer.sample2.mouse;

/**
 *
 * @author zhuo
 * @date 2018/5/30
 */
public class Mouse {

    public void onClick() {
        System.out.println("Mouse onClick");
    }

    public void onDoubleClick() {
        System.out.println("Mouse onDoubleClick");
    }

    public void onMove() {
        System.out.println("Mouse onMove");
    }

    public void onUp() {
        System.out.println("Mouse onUp");
    }

    public void onDown() {
        System.out.println("Mouse onDown");
    }

    public void onScroll() {
        System.out.println("Mouse onScroll");
    }
}
