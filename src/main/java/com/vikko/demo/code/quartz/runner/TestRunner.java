package com.vikko.demo.code.quartz.runner;

import com.vikko.demo.code.quartz.domain.service.QuartzService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward
 * @Date: 2020/11/25 14:12
 * @Description:
 */
@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private QuartzService quartzService;
	@Override
	public void run(String... args) throws Exception {
		HashMap<String,Object> map = new HashMap<>();
		map.put("name",1);
		quartzService.deleteJob("job", "test");
//		quartzService.addJob(TestJob.class, "job", "test", "0 * * * * ?", map);
	}
}
