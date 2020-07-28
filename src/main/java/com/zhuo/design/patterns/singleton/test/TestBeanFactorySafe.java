package com.zhuo.design.patterns.singleton.test;

import java.util.concurrent.CountDownLatch;

import com.zhuo.design.patterns.singleton.register.BeanFactory;


public class TestBeanFactorySafe {

	public static void main(String[] args) {

		int count = 200;
		// 发令枪，我就能想到运动员
		final CountDownLatch latch = new CountDownLatch(count);

		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						// 阻塞
						// count = 0 44就会释放所有的共享锁
						// 万箭齐发
						latch.await();
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 必然会调用，可能会有很多线程同时去访问getInstance()
					Object obj = BeanFactory
							.getBean("com.zhuo.design.patterns.singleton.Pojo");
					System.out.println(System.currentTimeMillis() + ":" + obj);
				}
			}.start(); // 每循环一次，就启动一个线程,具有一定的随机性

			// 每次启动一个线程，count --
			latch.countDown();

		}
		long end = System.currentTimeMillis();
		System.out.println("总耗时：" + (end - start));
	}

}