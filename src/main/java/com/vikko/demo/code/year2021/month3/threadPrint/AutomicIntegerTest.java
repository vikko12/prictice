package com.vikko.demo.code.year2021.month3.threadPrint;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: vikko
 * @Date: 2021/3/29 17:41
 * @Description:
 */
public class AutomicIntegerTest {

	private static final int MAX_PRINT_NUM = 100;
	private static final AtomicInteger atomicInteger = new AtomicInteger(0);

	public static void main(String[] args) {
		printAB();
	}

	public static void printAB() {
		new Thread(() -> {
			while (atomicInteger.get() < MAX_PRINT_NUM) {
				// 打印偶数.
				System.out.println("偶数"+ atomicInteger.get());
				if (atomicInteger.get() % 2 == 0) {
					System.out.println("偶数num:" + atomicInteger.get());
					atomicInteger.incrementAndGet();
				}
			}
		}).start();

		new Thread(() -> {
			while (atomicInteger.get() < MAX_PRINT_NUM) {
				// 打印奇数.
				System.out.println("奇数"+ atomicInteger.get());
				if (atomicInteger.get() % 2 == 1) {
					System.out.println("奇数num:" + atomicInteger.get());
					atomicInteger.incrementAndGet();
				}
			}
		}).start();
	}
	
}
