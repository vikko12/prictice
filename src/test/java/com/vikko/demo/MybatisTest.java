package com.vikko.demo;

import com.vikko.demo.code.year2021.month2.limit.SimpleRateLimiter;
import com.vikko.demo.project.UserService;
import java.util.stream.IntStream;
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


}
