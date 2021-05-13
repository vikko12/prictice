package com.vikko.demo.code;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: vikko
 * @Date: 2021/4/13 18:00
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
		map.put("test","test");
		int size = map.size();
		long longSize = map.mappingCount();
	}

}
