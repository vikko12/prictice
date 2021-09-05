package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/5 14:21
 * @Description: 贪心 跳跃游戏
 */
public class Jump {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int reach = 0;
        int nextReach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextReach = Math.max(i + nums[i], nextReach);
            if (nextReach >= nums.length - 1) {
                return (step + 1);
            }
            if (i == reach) {
                step++;
                reach = nextReach;
            }
        }
        return step;
    }


}
