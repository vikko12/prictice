package com.vikko.demo.december.function;

import java.util.function.DoubleConsumer;
import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: vikko
 * @Date: 2020/12/5 16:54
 * @Description:
 */
public class TestFunction {

	public static void main(String[] args) {

//		testDoubleConsumer(data -> System.out.println("first"+10 * data),
//				thenValue ->
//						System.out.println("second"+thenValue * 10));

		testFunction(data -> data + "before",
				String::length,
				data -> {
					System.out.println("this is function = " + data);
					return StringUtils.reverse(data);
				});
	}

	public static void testDoubleConsumer(DoubleConsumer consumer, DoubleConsumer then) {
		consumer.andThen(then).accept(0.4);
	}

	public static void testFunction(Function<String, String> before, Function<String, Integer> after,
			Function<String, String> f) {
		Integer length = f.compose(before).andThen(after).compose(data -> {
			System.out.println("data ==" + data);
			return StringUtils.reverse((String) data + "data");
		}).apply("String");
		System.out.println("length == " + length);
	}

}
