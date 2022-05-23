package com.vikko.demo.algorithm;

import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2022/1/27 17:19
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		long first = 1, second = 1, ret = 0, sum = 0;
		for(int i = 2; i < 50; i++) {
			//对题取模
			ret = first + second;
			first = second;
			second = ret;
			sum += ret % 2;
		}
		System.out.println(sum + 2);
	}

}
