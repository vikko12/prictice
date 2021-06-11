package com.vikko.demo.code.year2021.month5.count;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/6/7 16:50
 * @Description:
 */
public class App {

	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() throws Exception {
		long start = System.currentTimeMillis();
		CountTask countTask = new CountTask(0, 400, 100);
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);

		forkJoinPool.submit(countTask);
		System.out.println(countTask.get());
		System.out.println(System.currentTimeMillis() - start);
	}

//	public static void test2() throws Exception {
//		long start = System.currentTimeMillis();
//		List<Integer> collect = IntStream.rangeClosed(0, 10000000).boxed()
//				.collect(Collectors.toList());
//		int res = 0;
//		for (Integer integer : collect) {
//			res += integer;
//		}
//		System.out.println(res);
//		System.out.println(System.currentTimeMillis() - start);
//
//	}
}
