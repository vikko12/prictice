package com.vikko.demo.code.year2021.month2;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: vikko
 * @Date: 2021/2/12 15:42
 * @Description:
 */
public class CopyOnWriteArrayListTest {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("test", "test2", "test3", "test4");
		String[] strings = new String[list.size()];
		String[] arr = list.toArray(strings);
		System.out.println(arr.toString());
	}

	public static void test(){
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("test");
	}

}
