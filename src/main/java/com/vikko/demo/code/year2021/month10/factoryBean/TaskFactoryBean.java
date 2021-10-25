package com.vikko.demo.code.year2021.month10.factoryBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author: vikko
 * @Date: 2021/10/22 17:01
 * @Description:
 */

@AllArgsConstructor
@Data
public class TaskFactoryBean implements FactoryBean<Task> {

	private SomeService someService;
	private String cronExpression;

	@Override
	public Task getObject() throws Exception {
		return new CustomTask(someService, cronExpression);
	}

	@Override
	public Class<?> getObjectType() {
		return CustomTask.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
