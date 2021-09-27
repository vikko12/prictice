package com.vikko.demo.code.year2021.month9.cyclicBarrier;

import java.util.concurrent.Semaphore;

/**
 * @author: vikko
 * @Date: 2021/9/10 18:10
 * @Description:
 */
public class SemaphoreTest2 {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(-1);

		new Thread(()->{
			System.out.println("acquire star1============");
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("acquire step2============");
		}).start();


		new Thread(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semaphore.release();
		}).start();
	}

}
