package com.vikko.demo.code.year2021.month1.thread.RunnableTest;

/**
 * @author: vikko
 * @Date: 2021/1/26 14:39
 * @Description:
 */
public class MainTest {


	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}
}
