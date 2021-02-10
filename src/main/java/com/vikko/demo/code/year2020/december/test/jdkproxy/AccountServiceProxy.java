package com.vikko.demo.code.year2020.december.test.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: vikko
 * @Date: 2020/12/1 13:45
 * @Description:
 */
public class AccountServiceProxy implements InvocationHandler {

	private AccountService target;

	public AccountServiceProxy(AccountService target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object invoke = method.invoke(target, args);
		after();
		return invoke;
	}

	public void before(){
		System.out.println("这个是before方法");
	}


	public void after(){
		System.out.println("这个是after方法");
	}
}
