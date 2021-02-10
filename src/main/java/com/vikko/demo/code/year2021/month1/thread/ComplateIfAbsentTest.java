package com.vikko.demo.code.year2021.month1.thread;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/1/26 14:28
 * @Description:
 */
public class ComplateIfAbsentTest {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Map<String, String> map = Maps.newHashMap();
		map.computeIfAbsent("key1", k -> k + "append");
		System.out.println(map);
	}

}
