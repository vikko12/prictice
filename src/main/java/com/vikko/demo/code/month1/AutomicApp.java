package com.vikko.demo.code.month1;

/**
 * @author: vikko
 * @Date: 2021/1/20 16:03
 * @Description:
 */
public class AutomicApp {

	public static void main(String[] args) {
		AutomicTest automicTest = new AutomicTest();
		new Thread(()->automicTest.add()).start();
		new Thread(()->automicTest.compare()).start();
	}

}
