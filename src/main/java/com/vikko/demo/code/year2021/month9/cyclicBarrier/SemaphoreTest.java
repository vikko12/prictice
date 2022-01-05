package com.vikko.demo.code.year2021.month9.cyclicBarrier;

import java.util.concurrent.Semaphore;
import lombok.AllArgsConstructor;
import lombok.Data;

public class SemaphoreTest {
	public static void main(String[] args) {
		int N = 8;
		Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(i, semaphore)).start();
		}
	} 

	@Data
	@AllArgsConstructor
	static class Worker implements Runnable{
		private int num;
		private Semaphore semaphore;
		
		@Override
		public void run() {
			try {
				//tryAcquire返回Boolean值
				semaphore.acquire();
				System.out.println("工人"+this.num+"占用一个机器在生产...");
				Thread.sleep(2000);
				System.out.println("工人"+this.num+"释放出机器");
				semaphore.release();			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}