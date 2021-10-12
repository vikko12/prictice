package com.vikko.demo.config;

import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author: vikko
 * @Date: 2021/10/12 16:03
 * @Description:
 */
@Configuration
public class ExecuteConfig {

	@Bean("commonExecutor")
	public TaskExecutor commonExecutor(){

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 设置核心线程数
		executor.setCorePoolSize(20);
		// 设置最大线程数
		executor.setMaxPoolSize(20);
		// 设置队列容量
		executor.setQueueCapacity(Integer.MAX_VALUE);
		// 设置线程活跃时间（秒）
		executor.setKeepAliveSeconds(60);
		// 设置默认线程名称
		executor.setThreadNamePrefix("commonExecutor");
		// 设置拒绝策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 等待所有任务结束后再关闭线程池
		executor.setWaitForTasksToCompleteOnShutdown(true);
		return executor;
	}

}
