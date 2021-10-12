package com.vikko.demo.code.year2021.month7.batchQueue.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @author: vikko
 * @Date: 2021/10/12 19:26
 * @Description:
 */
public class CompleteTest {

	public static void main(String[] args) {

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "future Origin Value";
		});

		System.out.println(System.currentTimeMillis() + ":time 1");

		future.whenCompleteAsync(new BiConsumer<String, Throwable>() {
			@Override
			public void accept(String s, Throwable throwable) {
				System.out.println(System.currentTimeMillis() + ":;;;;;;;;" + s);
			}
		});

		System.out.println(System.currentTimeMillis() + ":time 2");

		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				//异常退出。
				future.completeExceptionally(e);
			}

			// CompletableFuture被通知线程任务完成。
			System.out.println(System.currentTimeMillis() + ":运行至此。");
			future.complete("this is complete value。");
		}).start();

		System.out.println(System.currentTimeMillis() + ":time 3");
	}

}
