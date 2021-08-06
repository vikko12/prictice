package com.vikko.demo.code.month1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: vikko
 * @Date: 2021/1/20 15:59
 * @Description:
 */

@Slf4j
public class AutomicTest {

	volatile int a = 1;
	volatile int b = 1;
	private static final String lock = "lock";
	private static final String lockCompare = "lockCompare";

	public void add() {
		synchronized (lock) {
			log.info("addStart" + String.valueOf(System.currentTimeMillis()));
			for (int i = 0; i < 10000; i++) {
				a++;
				b++;
			}
			log.info("addEnd" + String.valueOf(System.currentTimeMillis()));
		}


	}

	public void compare() {
		synchronized (lock) {
			log.info("compareStart" + String.valueOf(System.currentTimeMillis()));
			for (int i = 0; i < 10000; i++) {
				//a始终等于b吗？
				if (a < b) {
					log.info("a:{},b:{},{}", a, b, a > b);
					//最后的a>b应该始终是false吗？
				}
			}
			log.info("compareEnd" + String.valueOf(System.currentTimeMillis()));
		}

	}

}