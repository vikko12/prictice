package com.vikko.demo;

import com.vikko.demo.code.year2021.month7.batchQueue.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: vikko
 * @Date: 2021/10/12 16:09
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class BatchHandleTest {

	@Autowired
	TestService testService;

	@Test
	public void testBatchHandle(){
		testService.test();
	}


}
