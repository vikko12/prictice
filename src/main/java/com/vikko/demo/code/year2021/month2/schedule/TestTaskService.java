package com.vikko.demo.code.year2021.month2.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

/**
 * @author: vikko
 * @Date: 2021/2/5 16:39
 * @Description:
 */
@Service
@EnableScheduling
public class TestTaskService implements SchedulingConfigurer {

	private String SpringDynamicCronTask() {
		//查找db
		return "0/5 * * * * ?";
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		scheduledTaskRegistrar.addTriggerTask(()-> System.out.println("执行任务")
		, triggerContext -> {
			String s = SpringDynamicCronTask();
			// 任务触发，可修改任务的执行周期
			CronTrigger trigger = new CronTrigger(s);
			return trigger.nextExecutionTime(triggerContext);
		});
	}
}
