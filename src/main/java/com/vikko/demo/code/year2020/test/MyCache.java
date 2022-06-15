package com.vikko.demo.code.year2020.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache<K, V> {

	final Map<K, V> cache = new ConcurrentHashMap<>();

	V get(K key) {
		V v = cache.get(key);
		if(Objects.nonNull(v)){
			return v;
		}
		v = selectFromDb(key);
		cache.put(key, v);
		return v;
	}

	private V selectFromDb(K key){
		//todo select db, 伪代码
		return null;
	}

	V put(K key, V value) {
		if(cache.size() >= 10000){
			throw new RuntimeException("最大存储10000条数据");
		}
		cache.put(key, value);
		return value;
	}
}