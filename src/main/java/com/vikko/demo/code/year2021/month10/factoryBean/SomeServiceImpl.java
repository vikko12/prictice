package com.vikko.demo.code.year2021.month10.factoryBean;

/**
 * @author: vikko
 * @Date: 2021/10/22 16:58
 * @Description:
 */
public class SomeServiceImpl implements SomeService {

	@Override
	public void doSomething() {
		System.out.println("current ts" + System.currentTimeMillis());
	}
}
