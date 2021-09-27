package com.vikko.demo.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author: vikko
 * @Date: 2021/9/26 16:14
 * @Description:
 */

@EnableRetry
@Configuration
public class RetryConfig {

	@Bean(value = "retryTemplateSimple")
	public RetryTemplate retryTemplateSimple() {
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(4);

		FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
		backOffPolicy.setBackOffPeriod(3000);

		RetryTemplate template = new RetryTemplate();
		template.setRetryPolicy(retryPolicy);
		template.setBackOffPolicy(backOffPolicy);
		return template;
	}


	@Bean(value = "retryTemplate")
	public RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();

		/// 回退固定时间(秒)
       /* FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(1000L);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);*/

		// 指数回退(秒)，第一次回退1s，第二次回退2s
		ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
		exponentialBackOffPolicy.setInitialInterval(1000L);
		exponentialBackOffPolicy.setMultiplier(2);
		retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);

		// 重试策略
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(5);
		retryTemplate.setRetryPolicy(retryPolicy);

		// 设置监听器，open和close分别在启动和结束时执行一次
		RetryListener[] listeners = {
				new RetryListener() {
					@Override
					public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
						System.out.println("open");
						return true;
					}
					@Override
					public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
							Throwable throwable) {
						System.out.println("close");

					}
					@Override
					public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
							Throwable throwable) {
						System.out.println("on error");
					}
				}
		};
		retryTemplate.setListeners(listeners);

		return retryTemplate;
	}

}
