package com.vikko.demo.code.year2021.month7.batchQueue;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author: vikko
 * @Date: 2021/10/12 16:35
 * @Description:
 */
@Service
public class TestService {

	@Resource(name = "commonExecutor")
	TaskExecutor commonExecutor;

	@Autowired
	MockBatchHandle mockBatchHandle;

	public void test() {
		commonExecutor.execute(
				() -> {
					int num = 1;
					while (true) {
						try {
							System.out.println("生产数据 : " + num );
							mockBatchHandle.addItem(num);
							num++;
							long time = (long) (Math.random() * 1000);
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		);

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
