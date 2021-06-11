package com.vikko.demo.code.year2021.month5;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/6/7 11:46
 * @Description:
 */
public class ForkJoinPoolTest {


	public static void main(String[] args) {
		testParallelStream();
	}



	public static void testForkJoinPool(){

		ForkJoinPool pool = new ForkJoinPool();
	}









	public static void testParallelStream(){
		List<Integer> intList = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
		List<Integer> after = intList.parallelStream().map(data -> {
			System.out.println(data);
			return data * 2;
		}).collect(Collectors.toList());
		after.forEach(System.out::println);
	}

}
