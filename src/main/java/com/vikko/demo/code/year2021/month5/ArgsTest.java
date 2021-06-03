package com.vikko.demo.code.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/6/2 16:45
 * @Description:
 */
public class ArgsTest {

	public static void main(String[] args) {
		test("1","2");
	}

	public static void test(String... args){
		int length = args.length;
		String arg = args[0];
		String arg2 = args[1];
		System.out.println(1);
	}

}
