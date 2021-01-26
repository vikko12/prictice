package com.vikko.demo.code.month1;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author: vikko
 * @Date: 2021/1/19 20:11
 * @Description:
 */
public class SafeListTest {

//	private static Vector<String> safeList = new Vector<>();
	private static CopyOnWriteArrayList<String> safeList = new CopyOnWriteArrayList<>();

	private static CountDownLatch countDownLatch = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		//初始化
		safeList.add("叫练");
		MySerive fishSerive = new MySerive();
		long start = System.currentTimeMillis();
		new Thread(()->{
			fishSerive.read();
			countDownLatch.countDown();
		},"叫练读线程").start();

		new Thread(()->{
			fishSerive.write();
			countDownLatch.countDown();
		},"叫练写线程").start();
		countDownLatch.await();
		System.out.println("花费:"+(System.currentTimeMillis()-start));
	}

	private static class MySerive {
		//读
		public void read() {
			for (int i=0 ;i<1000000; i++) {
				safeList.get(0);
			}
		}

		//写
		public void write() {
			for (int i=0 ;i<100000; i++) {
				safeList.add("叫练");
			}
		}
	}
}
