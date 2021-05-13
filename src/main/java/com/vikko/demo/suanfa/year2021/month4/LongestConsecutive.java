package com.vikko.demo.suanfa.year2021.month4;

import com.vikko.demo.code.year2020.june.IntTest;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: vikko
 * @Date: 2021/4/16 18:17
 * @Description: leetcode 128
 */
public class LongestConsecutive {

	public static void main(String[] args) {
		int i = longestConsecutive(new int[]{1,2,0,1});
		System.out.println(i);
	}

	public static int longestConsecutive(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
		for (int num : nums) {
			queue.add(num);
		}
		int max = 0;
		int res = 0;
		int pre = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == pre){
				continue;
			}
			if (cur - pre == 1) {
				max++;
				res = Math.max(max, res);
			} else {
				max = 0;
			}
			pre = cur;
		}

		return res+1;
	}

	public static int longestConsecutive2(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}

		int longestStreak = 0;

		for (int num : set) {
			if (!set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}

}
