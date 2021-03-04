package com.vikko.demo.code.year2020.december.test.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: vikko
 * @Date: 2020/12/2 21:43
 * @Description:
 */
public class Client {
	public static void main(String[] args) {
		//创建目标对象
		AccountService target = new AccountService();
		//
		//创建代理对象
		AccountService proxy = (AccountService) Enhancer.create(target.getClass(),
				new AccountAdvice());
		proxy.transfer();
	}
}
