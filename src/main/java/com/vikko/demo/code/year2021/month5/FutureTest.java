package com.vikko.demo.code.year2021.month5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: vikko
 * @Date: 2021/6/2 17:12
 * @Description:
 */
public class FutureTest {


	public static void test(){
		ExecutorService es = Executors.newCachedThreadPool();
		Future submit = es.submit(() -> System.out.println(1 + 2));

		CompletableFuture<Long> future = CompletableFuture
				.supplyAsync(System::currentTimeMillis);
	}



}
