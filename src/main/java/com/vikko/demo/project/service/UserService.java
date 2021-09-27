package com.vikko.demo.project.service;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:30
 * @Description:
 */
public interface UserService {

	/**
	 * test
	 * @return
	 */
	Integer test();

	/**
	 * 事务测试
	 */
	void transactionTest();

	/**
	 * 测试重试
	 */
	void testRetry();
}
