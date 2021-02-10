package com.vikko.demo.code.year2021.month2.schedule.v2;

import java.util.Calendar;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author: vikko
 * @Date: 2021/2/5 18:13
 * @Description:
 */
public class TestJob implements InitializingBean {

	@Autowired
	private DefaultSchedulingConfigurer defaultSchedulingConfigurer;

	@Override
	public void afterPropertiesSet() throws Exception {
		new Thread() {
			@Override
			public void run() {

				try {
					// 等待任务调度初始化完成
					while (!defaultSchedulingConfigurer.inited()) {
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("任务调度初始化完成，添加任务");
				defaultSchedulingConfigurer.addTriggerTask("task", new TriggerTask(new Runnable() {

					@Override
					public void run() {
						System.out.println("run job..." + Calendar.getInstance().get(Calendar.SECOND));

					}
				}, new CronTrigger("0/5 * * * * ? ")));
			}

			;
		}.start();
		new Thread() {
			@Override
			public void run() {

				try {
					Thread.sleep(30000);
				} catch (Exception e) {
				}
				System.out.println("重置任务............");
				defaultSchedulingConfigurer.resetTriggerTask("task", new TriggerTask(new Runnable() {

					@Override
					public void run() {
						System.out.println("run job..." + Calendar.getInstance().get(Calendar.SECOND));

					}
				}, new CronTrigger("0/10 * * * * ? ")));
			}

			;
		}.start();
	}
}
