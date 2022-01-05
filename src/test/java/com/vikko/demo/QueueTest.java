package com.vikko.demo;

import com.vikko.demo.code.year2021.month7.batchQueue.ScheduleExecutorTest;
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
public class QueueTest {

	@Autowired
	ScheduleExecutorTest scheduleExecutorTest;

	@Test
	public void test(){
		scheduleExecutorTest.testQueue();
	}

}
