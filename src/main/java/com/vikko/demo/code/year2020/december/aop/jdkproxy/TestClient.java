package com.vikko.demo.code.year2020.december.aop.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author: vikko
 * @Date: 2020/12/1 13:46
 * @Description:
 */
public class TestClient {

	public static void main(String[] args) {

		AccountService target = new AccountServiceImpl();
		AccountService proxy = (AccountService) Proxy
				.newProxyInstance(target.getClass().getClassLoader(),
						target.getClass().getInterfaces(), new AccountServiceProxy(target));
		proxy.modify();
	}

}
