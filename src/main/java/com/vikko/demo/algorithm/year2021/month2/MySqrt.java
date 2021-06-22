package com.vikko.demo.algorithm.year2021.month2;

/**
 * @author: vikko
 * @Date: 2021/2/8 18:49
 * @Description:
 */
public class MySqrt {

	public static void main(String[] args) {
		int i = mySqrt(10202);
		System.out.println(i);
	}

	public static int mySqrt(int x) {
		if(x == 0){
			return 0;
		}
		int res = 1;
		while (x / (res + 1) >= (res + 1)) {
			res++;
		}
		return res;
	}

	public static int sqrt(int x){
		return (x);
	}

}
