package com.vikko.demo.code.year2021.month9.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/9/6 16:35
 * @Description:
 */
public class CyclicBarrierPrint {

	public static void main(String[] args) throws Exception {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
			try {
				System.out.println("sleep  " + System.currentTimeMillis()/1000);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		new Thread(()->{
			IntStream.rangeClosed(0,1000).forEach(i->{
				if(i % 100 == 0){
					try {
						System.out.println("A = " + i);
						cyclicBarrier.await(5, TimeUnit.SECONDS);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}).start();

		new Thread(()->{
			IntStream.rangeClosed(1000,1500).forEach(i->{
				if(i % 100 == 0){
					try {
						System.out.println("b = " + i);
						cyclicBarrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}).start();



	}

}
