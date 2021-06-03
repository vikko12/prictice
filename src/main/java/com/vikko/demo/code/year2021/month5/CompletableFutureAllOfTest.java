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
public class CompletableFutureAllOfTest {

	public static void main(String[] args) throws Exception{

		ExecutorService saveDataExecutor = Executors.newCachedThreadPool();


		long start = System.currentTimeMillis();

		CompletableFuture<Boolean> f1 = CompletableFuture.supplyAsync(() -> {
			doSleep(2000);
			System.out.println("f1结束= " + (System.currentTimeMillis() - start));
			return true;
		}, saveDataExecutor);
		CompletableFuture<Boolean> f2 = CompletableFuture.supplyAsync(() -> {
			doSleep(4000);
			System.out.println("f2结束= " + (System.currentTimeMillis() - start));

			return true;
		}, saveDataExecutor);
		CompletableFuture<Boolean> f3 = CompletableFuture.supplyAsync(() -> {
			doSleep(10000);
			System.out.println("f3结束= " + (System.currentTimeMillis() - start));
			return true;
		}, saveDataExecutor);

		CompletableFuture.allOf(f1,f2,f3).join();


		long end = System.currentTimeMillis();

		System.out.println(end-start);
		System.out.println("====================");

	}

	private static void doSleep(int millis){
		try {
			Thread.sleep(millis);
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
