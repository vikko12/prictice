package com.vikko.demo.december.suanfa;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2020/12/15 19:36
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = groupAnagrams(strings);
		System.out.println(lists);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = String.valueOf(chars);
			if(!map.containsKey(sortedStr)){
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}
		return new ArrayList<>(map.values());
	}



	public static String sort(String target){
		char[] chars = target.toCharArray();
		Arrays.sort(chars);
		String res = "";
		for (char aChar : chars) {
			res += aChar;
		}
		return res;
	}


	public static List<List<String>> groupAnagrams2(String[] strs) {
		HashMap<String, List<String>> listHashMap = new HashMap<>();
		for (String str : strs) {
			if(listHashMap.size() == 0){
				listHashMap.put(str, Collections.singletonList(str));
				continue;
			}
			listHashMap.forEach((k,v)->{
				if(allMatch(k,str)){
					v.add(str);
					return;
				}
			});
			listHashMap.put(str, Collections.singletonList(str));
		}
		return Lists.newArrayList(listHashMap.values());
	}

	public static Boolean allMatch(String source, String target){
		char[] sourceArray = source.toCharArray();
		for (char c : sourceArray) {
			if(singleMatch(target, c)){
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

	public static Boolean singleMatch(String target, char c){
		char[] chars = target.toCharArray();
		for (char aChar : chars) {
			if(aChar == c){
				return true;
			}
		}
		return false;
	}
}
