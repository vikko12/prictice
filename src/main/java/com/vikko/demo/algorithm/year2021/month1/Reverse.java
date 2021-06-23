package com.vikko.demo.algorithm.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/8 14:53
 * @Description:
 */
public class Reverse {

	public static void main(String[] args) {
		System.out.println(reverse(11121));
	}

	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return (int) res == res ? (int) res : 0;
	}

}
