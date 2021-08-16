package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/8/13 14:25
 * @Description:
 */
public class HamminDistance {

	public static void main(String[] args) {
		int i = hammingDistance(1, 4);
		System.out.println(i);
	}
	public static int hammingDistance(int x, int y) {
		int xLeft = x, yLeft = y, res = 0;
		while(xLeft != 0 || yLeft != 0){
			if(xLeft % 2 != yLeft % 2){
				res++;
			}
			xLeft = xLeft / 2;
			yLeft = yLeft / 2;
		}
		return res;
	}

}
