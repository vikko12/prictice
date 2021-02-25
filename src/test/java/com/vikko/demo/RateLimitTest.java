package com.vikko.demo;

import com.vikko.demo.code.year2021.month1.copy.test.TestService;
import com.vikko.demo.code.year2021.month2.limit.SimpleRateLimiter;
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
public class RateLimitTest {

	@Autowired
	SimpleRateLimiter simpleRateLimiter;

	@Test
	public void test() {
		IntStream.rangeClosed(0,20).boxed().forEach(data->{
		boolean b = simpleRateLimiter.actionLimit("vikko", "test", 1, 5);
		System.out.println("result =========== " + data + b);
		});

	}

	@Test
	public void getKeyCount(){

	}


}
