package com.vikko.demo.code.year2021.month1.thread;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/1/26 15:56
 * @Description:
 */
public class CompletableFutureTest {

	public static void main(String[] args) {
//		supplyTest();
		runTest();
	}


	public static void supplyTest() {
		long start = System.currentTimeMillis();
		System.out.println("start ---------" + start);
		List<CompletableFuture<String>> futures = IntStream.range(0, 21).parallel().mapToObj(data -> {

			return CompletableFuture.supplyAsync(() -> {
				System.out
						.println(Thread.currentThread().getName() + System.currentTimeMillis() + "-" + data);
				sleep(3);
				return String.valueOf(data);
			});
		}).collect(Collectors.toList());
		futures.stream().map(CompletableFuture::join).collect(Collectors.toList())
				.forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("finish =======" + (end -start)/1000);


	}

	public static void runTest() {
		long start = System.currentTimeMillis();
		System.out.println("start ---------" + start);
		List<CompletableFuture<Void>> futures = IntStream.range(0, 21).parallel().mapToObj(data -> {
			return CompletableFuture.runAsync(() -> {
				System.out
						.println(Thread.currentThread().getName() + System.currentTimeMillis() + "-" + data);
				sleep(3);
			});
		})
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println("finish =======" + (end -start)/1000);
	}


	private static void sleep(Integer second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
