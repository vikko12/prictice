package com.vikko.demo.code.year2021.month7.batchQueue;

import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.CollectionUtils;

/**
 * @author: vikko
 * @Date: 2021/10/12 16:15
 * @Description:
 */
@Log4j2
public abstract class BaseBatchQueueManage<T> {


	protected void doExecute(int maxItemNum, int minMillTime, Consumer<List<T>> consumer){
		BlockingQueue<T> queue = getQueue();
		while (true) {
			try {
				List<T> list = new ArrayList<>(maxItemNum);
				Queues.drain(queue, list, maxItemNum, minMillTime, TimeUnit.MILLISECONDS);
				if(!CollectionUtils.isEmpty(list)){
					consumer.accept(list);
				}else {
					System.out.println("empty");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



	protected abstract BlockingQueue<T> getQueue();

}
