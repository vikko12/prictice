package com.vikko.demo;

import com.vikko.demo.project.mapper.UserMapper;
import com.vikko.demo.project.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: vikko
 * @Date: 2021/1/30 15:23
 * @Description:
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MybatisTest {

	@Autowired
	UserService userService;

	@Test
	public void getKeyCount(){
		Integer count = userService.test();
		System.out.println(count);
	}


	@Test
	public void transactionTest(){
		userService.transactionTest();
	}

	@Autowired
	UserMapper userMapper;
	@Test
	public void testOverload(){
		int allCount = userMapper.userCount(1L);
//		int likeCount = userMapper.userCount("v");
		System.out.println(allCount + "====" + 1);
	}

	@Test
	public void retryTest(){
		userService.testRetry();
	}
}
