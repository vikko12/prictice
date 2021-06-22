package com.vikko.demo.algorithm.year2021.month1;

/**
 * @author: vikko
 * @Date: 2021/1/11 15:51
 * @Description:
 */
public class FindStr {

	public static void main(String[] args) {
		String[] nums = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String target = "ball";
		System.out.println(findString2(nums, target));
	}

	public static int findStr(String[] words, String s) {
		int left = 0, right = words.length - 1;
		while (left < right) {

			if (words[right].equals("")) {
				right--;
				continue;
			}
			if (words[left].equals("")) {
				left++;
				continue;
			}

			int mid = (left + right) >> 1;

			if (words[mid].equals("")) {
				while (true) {

				}
			}
			if (words[mid].compareTo(s) < 0) {
				left = mid;
			}
			if (words[mid].compareTo(s) > 0) {
				right = mid;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * from leecode
	 * @param words
	 * @param s
	 * @return
	 */
	public static int findString2(String[] words, String s) {
		int left = 0, right = words.length - 1;
		while (left <= right) {
			while (words[left].equals("") && left < right) {
				left++;
			}
			while (right >= 0 && words[right].equals("")) {
				right--;
			}
			int mid = (left + right) >> 1;
			while (mid <= right && words[mid].equals("")) {
				mid++;
			}
			if (words[mid].compareTo(s) < 0) {
				left = mid + 1;
			} else if (words[mid].compareTo(s) > 0) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}


}
