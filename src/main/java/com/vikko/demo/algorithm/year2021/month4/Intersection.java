package com.vikko.demo.algorithm.year2021.month4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: vikko
 * @Date: 2021/4/16 15:28
 * @Description:
 */
public class Intersection {

	public static void main(String[] args) {
		int[] a = {1,2,5,7,8,88};
		int[] b = {1,2,5,7,8,88};
		System.out.println(Arrays.toString(intersection(a,b)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> result = new HashSet<>();
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length){
			if(nums1[i] == nums2[j]){
				result.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i] > nums2[j]){
				j++;
			}else {
				i++;
			}
		}
		return result.stream().mapToInt(Integer::valueOf).toArray();

	}
}
