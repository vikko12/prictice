package com.vikko.demo.algorithm.year2021.month4;

import java.util.Arrays;

/**
 * 奇数在前
 */
public class Exchange {

    public static void main(String[] args) {
        int[] a = {3,6,2,7,3,10};
        exchange(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) != 0) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
