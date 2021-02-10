package com.vikko.demo.code.year2021.month1.thread.RunnableTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author: vikko
 * @Date: 2021/1/26 15:07
 * @Description:
 */
public class CountDownLaunchTest {

	private static CountDownLatch latch = new CountDownLatch(2);

	@Deprecated
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-before-sleep-" + System.currentTimeMillis());
			sleep(1);
			System.out.println(Thread.currentThread().getName() + "-after-sleep-" + System.currentTimeMillis());
			latch.countDown();
		}, "thread1");
		t1.start();

		Thread t2 = new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-before-sleep-" + System.currentTimeMillis());
			sleep(3);
			System.out.println(Thread.currentThread().getName() + "-after-sleep-" + System.currentTimeMillis());
			latch.countDown();
		}, "thread2");
		t2.start();

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("finish-" + System.currentTimeMillis());
	}

	private static void sleep(Integer second){
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
