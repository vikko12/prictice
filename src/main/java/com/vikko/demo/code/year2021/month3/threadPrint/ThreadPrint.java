package com.vikko.demo.code.year2021.month3.threadPrint;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author: vikko
 * @Date: 2021/3/29 16:44
 * @Description:
 */
public class ThreadPrint {
	private static int count = 0;
	private static final Object LOCK = new Object();

	CountDownLatch countDownLatch = new CountDownLatch(5);

	public static void main(String[] args) {
		solution1();
	}

	public static void solution1() {
		Runnable printer = () -> {
			while (count <= 100) {
				synchronized (LOCK) {
					System.out.println(Thread.currentThread().getName() + " -> " + count++);
					LOCK.notify();
					if (count <= 100) {
						try {
							// 让出当前的
							LOCK.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		CompletableFuture.allOf(
				CompletableFuture.runAsync(printer),
				CompletableFuture.runAsync(printer)
		).join();
	}

	public static void solution2() {
		new Thread(() -> {
			while (count < 100) {
				synchronized (LOCK) {
					if ((count & 1) == 0) {
						System.out.println("偶数线程 -> " + count++);
					}
				}
			}
		}).start();

		new Thread(() -> {
			while (count < 100) {
				synchronized (LOCK) {
					if ((count & 1) == 1) {
						System.out.println("奇数线程 -> " + count++);
					}
				}
			}
		}).start();
	}
	

	public static void solution3() {
		CompletableFuture<Void> t1 = CompletableFuture.runAsync(() -> {
			while (count < 100) {
//				System.out.println("偶数count" + count);
				synchronized (LOCK) {
					if ((count & 1) == 0) {
						System.out.println("偶数线程 -> " + count++);
					}
				}
			}
		});
		CompletableFuture<Void> t2 = CompletableFuture.runAsync(() -> {
			while (count < 100) {
				synchronized (LOCK) {
//					System.out.println("奇数count" + count);
					if ((count & 1) == 1) {
						System.out.println("奇数线程 -> " + count++);
					}
				}
			}
		});
//		CompletableFuture.allOf(t1, t2).join();
	}
}
