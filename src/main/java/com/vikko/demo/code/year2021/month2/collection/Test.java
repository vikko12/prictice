package com.vikko.demo.code.year2021.month2.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: vikko
 * @Date: 2021/2/12 16:12
 * @Description:
 */
public class Test {

	public static void main(String[] args) {

		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

		concurrentHashMap.put("test","testValue");

		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("key","value");
	}





}
