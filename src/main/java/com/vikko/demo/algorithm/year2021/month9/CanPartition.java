package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/5 17:22
 * @Description: 背包问题
 */
public class CanPartition {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //第一层for 是选取当前数组的元素cur，
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            //第二层是用target-cur，用元素值递减
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 7, 3};
        System.out.println(canPartition(a));

    }
}
