package com.vikko.demo.code.year2021.month2.guava;

import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: vikko
 * @Date: 2021/2/20 14:32
 * @Description:
 */
public class CollectionTest {

	public static void main(String[] args) {
		hashMapTest();
	}

	public static void hashMapTest(){
		System.out.println(111);
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("test","test");
		hashMap.put("test2","test");
	}

	public static void conCurrentHashMapTest(){
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.size();
		map.mappingCount();
		map.put("test","test");
	}

	public static void guavaTest(){
		Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
		Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6);
		Sets.SetView<Integer> inter = Sets.intersection(set1, set2); //交集
		System.out.println(inter);
		Sets.SetView<Integer> diff = Sets.difference(set1, set2); //差集,在A中不在B中
		System.out.println(diff);
		Sets.SetView<Integer> union = Sets.union(set1, set2); //并集
		System.out.println(union);

		Set<Integer> difference = Sets.difference(set1, set2);
	}


}
