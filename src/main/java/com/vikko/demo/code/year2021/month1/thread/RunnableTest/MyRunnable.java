package com.vikko.demo.code.year2021.month1.thread.RunnableTest;

/**
 * @author: vikko
 * @Date: 2021/1/26 14:36
 * @Description:
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-before-sleep-" + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-after-sleep-" + System.currentTimeMillis());
	}
}
