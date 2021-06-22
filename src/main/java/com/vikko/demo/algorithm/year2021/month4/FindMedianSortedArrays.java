package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/13 14:15
 * @Description:
 */
public class FindMedianSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int ll = nums1.length;
		int rl = nums2.length;
		int[] temp = new int[nums1.length + nums2.length];
		int i = 0, j = 0, cur = 0;
		while (i < ll && j < rl) {
			if (nums1[i] <= nums2[j]) {
				temp[cur++] = nums1[i++];
			} else {
				temp[cur++] = nums2[j++];
			}
		}
		//handle left
		while (i < ll) {
			temp[cur++] = nums1[i++];
		}
		while (j < rl) {
			temp[cur++] = nums2[j++];
		}
		if (ll + rl == 0) {
			return 0;
		}
		if (((ll + rl) & 1) == 1) {
			return temp[(ll + rl) / 2];
		} else {
			return (temp[(ll + rl) / 2] + temp[(ll + rl - 1) / 2]) / 2.0;
		}

	}


}
