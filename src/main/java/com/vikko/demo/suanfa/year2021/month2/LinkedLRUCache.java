package com.vikko.demo.suanfa.year2021.month2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author: vikko
 * @Date: 2021/3/2 12:02
 * @Description:
 */
public class LinkedLRUCache<K, V> extends LinkedHashMap<K, V> {

	private int capacity;

	public LinkedLRUCache(int capacity) {
		super(16, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		System.out.println("removeEldestEntry:(" + eldest.getKey() + "," + eldest.getValue() + ")");
		return size() > capacity;
	}

	public static void main(String[] args) {
		LinkedLRUCache<String, String> cache = new LinkedLRUCache<>(5);
		IntStream.rangeClosed(0,10).boxed().forEach(item->{
			cache.put(String.valueOf(item),"test");
		});
		System.out.println(cache);
	}

}