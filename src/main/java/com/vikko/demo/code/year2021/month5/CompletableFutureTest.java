package com.vikko.demo.code.year2021.month5;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author: vikko
 * @Date: 2021/6/2 18:20
 * @Description:
 */
public class CompletableFutureTest {

	public static void main(String[] args) throws Exception{

		ExecutorService saveDataExecutor = Executors.newCachedThreadPool();

		List<CompletableFuture<Boolean>> futures = Lists.newArrayList();

		long start = System.currentTimeMillis();

		futures.add(CompletableFuture.supplyAsync(() -> {
			doSleep(2000);
			return true;
		}, saveDataExecutor));
		futures.add(CompletableFuture.supplyAsync(() -> {
			doSleep(3000);
			return true;
		}, saveDataExecutor));
		futures.add(CompletableFuture.supplyAsync(() -> {
			doSleep(10000);
			return true;
		}, saveDataExecutor));

		List<Boolean> collect = futures.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());


		long end = System.currentTimeMillis();

		System.out.println(end-start);
		System.out.println("====================");

	}

	private static void doSleep(int millis){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void test() {
		//这个其实是异步实现的串行，并没有必要
		CompletableFuture<String> future = CompletableFuture
				.supplyAsync(() -> "hello world")
				.thenApply(s -> s + "qq")
				.thenApply(String::toUpperCase);

		System.out.println(1);
		System.out.println(future.join());
		System.out.println(2);

	}






}
