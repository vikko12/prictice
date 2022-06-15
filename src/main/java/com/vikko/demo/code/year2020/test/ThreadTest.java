package com.vikko.demo.code.year2020.test;

public class ThreadTest {

	private int x = 0;
	private int expect = 0;
	private static final Object LOCK = new Object();

	public void add() {
		int current = x;
		x = current + 1;
	}

	public void go() {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				@Override
				public void run() {
					if(x == expect){
						synchronized (LOCK){
							add();
							expect++;
							System.out.println(x);
						}
					}

				}
			}.start();
		}
	}

	public static void main(String[] args) {
		new ThreadTest().go();
	}
}