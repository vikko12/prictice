package com.vikko.demo.code.year2021.month3.threadPrint;

import java.util.concurrent.CountDownLatch;

/**
 * @author: vikko
 * @Date: 2021/3/29 17:05
 * @Description:
 */
public class CountDownLatchTest {

	private static final int MAX_PRINT_NUM = 100;
	private static  int count = 0;

	public static void main(String[] args) {
		solution();
	}

	public static  void solution(){

		CountDownLatch countDownLatch = new CountDownLatch(2);

		new Thread(() -> {
			while (count < MAX_PRINT_NUM) {
//				System.out.println("偶数"+ count);
				if (count % 2 == 0) {
					System.out.println("偶数num:" + count);
					count++;

				}
			}
			// 偶数线程执行完则计数器减一
			countDownLatch.countDown();
		}).start();

		new Thread(() -> {
			while (count < MAX_PRINT_NUM) {
//				System.out.println("奇数"+ count);
				if (count % 2 == 1) {
					System.out.println("奇数num:" + count);
					count++;
				}
			}
			// 奇数线程执行完则计数器减一
			countDownLatch.countDown();
		}).start();



		try {
			countDownLatch.await();
		} catch (Exception e) {
		}

		System.out.println("主线程结束");


	}
}
