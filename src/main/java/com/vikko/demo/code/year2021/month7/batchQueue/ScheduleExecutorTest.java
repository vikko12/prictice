package com.vikko.demo.code.year2021.month7.batchQueue;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @author: vikko
 * @Date: 2021/12/9 14:03
 * @Description:
 */

@Component
public class ScheduleExecutorTest {

	@Autowired
	ThreadPoolTaskScheduler scheduler;

	private ScheduledFuture<?> future;
	public static Integer batchSize = 5;

	public void testQueue() {

		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

		List<Integer> list = IntStream.rangeClosed(0, 25).boxed().collect(Collectors.toList());
		LinkedBlockingDeque<Integer> queue = Queues.newLinkedBlockingDeque(list);

		future = scheduler.schedule(() -> {
			List<Integer> subList = Lists.newArrayList();
			int count = 0;
			while (!queue.isEmpty() && count < batchSize) {
				subList.add(queue.pop());
				count++;
			}
			System.out.println(subList);
			if (queue.isEmpty() && future != null) {
				future.cancel(true);
				System.out.println("stop");
			}
		}, new CronTrigger("*/1 * * * * ?"));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
