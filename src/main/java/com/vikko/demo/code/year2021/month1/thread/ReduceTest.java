package com.vikko.demo.code.year2021.month1.thread;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/1/26 18:02
 * @Description:
 */
public class ReduceTest {

	public static void main(String[] args) {
		test1();;
		test2();
	}

	public static void test1(){
		long start = System.currentTimeMillis();

		Integer reduce = init().stream().reduce(0, Integer::sum);
		System.out.println(reduce + "reduce cost ========" + (System.currentTimeMillis()-start));

	}
	public static void test2(){
		long start = System.currentTimeMillis();
		Integer reduce = init().stream().mapToInt(data->data).sum();
		System.out.println(reduce + "sum cost ========" + (System.currentTimeMillis()-start));
	}

	public static List<Integer> init(){
		return IntStream.rangeClosed(0, 100000).boxed()
				.collect(Collectors.toList());
	}

}
