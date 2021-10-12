package com.vikko.demo.code.year2021.month7.batchQueue;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @author: vikko
 * @Date: 2021/10/12 16:34
 * @Description:
 */
@Component
public class MockBatchHandle extends BaseBatchQueueManage<Integer> {

	@Resource(name = "commonExecutor")
	TaskExecutor commonExecutor;

	final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

	private Thread daemonThread;


	@Override
	protected BlockingQueue<Integer> getQueue() {
		return queue;
	}

	@PostConstruct
	private void initMethod() {
		init();
	}

	private void init() {
		daemonThread = new Thread(() -> {
			execute();
		});
		daemonThread.setName("DelayQueueMonitor");
		daemonThread.start();
	}

	private void execute() {
		super.doExecute(10, 10000,list -> System.out.println(list + ", size:" + list.size()));
	}

	public void addItem(Integer item){
		queue.add(item);
	}

}
