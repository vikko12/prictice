package com.vikko.demo.december.test.cglib;

import io.lettuce.core.dynamic.intercept.MethodInvocation;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author: vikko
 * @Date: 2020/12/2 21:40
 * @Description:
 */
public class AccountAdvice implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
			throws Throwable {
		before();
		Object result = methodProxy.invokeSuper(o, objects);
		after();
		return result;
	}

	/**
	 * 前置增强
	 */
	private void before() {
		System.out.println("========this is before=========");
	}
	/**
	 * 前置增强
	 */
	private void after() {
		System.out.println("========this is after=========");
	}
}
