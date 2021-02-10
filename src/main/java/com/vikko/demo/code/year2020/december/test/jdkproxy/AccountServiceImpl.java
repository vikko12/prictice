package com.vikko.demo.code.year2020.december.test.jdkproxy;

/**
 * @author: vikko
 * @Date: 2020/12/1 13:44
 * @Description:
 */
public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer() {
		System.out.println("进行转账业务");
	}

	@Override
	public void modify() {
		System.out.println("进行modify业务");
	}
}
