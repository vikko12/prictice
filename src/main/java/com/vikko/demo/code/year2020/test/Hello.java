package com.vikko.demo.code.year2020.test;

/**
 * @author: vikko
 * @Date: 2022/5/31 14:05
 * @Description:
 */
public class Hello {

	public Hello() {
		System.out.println("Hello create");
	}

	{
		System.out.println("I'm hello class");
	}

	static {
		System.out.println("static hello");
	}
}
