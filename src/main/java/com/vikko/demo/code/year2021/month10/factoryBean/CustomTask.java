package com.vikko.demo.code.year2021.month10.factoryBean;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: vikko
 * @Date: 2021/10/22 16:54
 * @Description:
 */
@Service
@AllArgsConstructor
public class CustomTask implements Task {

	private SomeService someService;
	private String cronExpression;


	@Override
	public void execute() {
		someService.doSomething();
	}

	@Override
	public void setCron(String cron) {
		this.cronExpression = cron;
	}

	@Override
	public String getCron() {
		return this.cronExpression;
	}
}
