package com.vikko.demo.code.year2021.month10.factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: vikko
 * @Date: 2021/10/22 17:05
 * @Description:
 */
@Configuration
public class TaskFactoryBeanConfig {

	@Bean
	public TaskFactoryBean customTask(){
		return new TaskFactoryBean(new SomeServiceImpl(), "*/5 * * * * ");
	}


	@Bean
	public TaskFactoryBean otherTask(){
		return new TaskFactoryBean(new SomeServiceImpl(), "*/5 * * * * ");
	}

}
