package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/5 12:39
 * @Description:
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        if(len == 1 || nums[0] > nums[1]){
            return 0;
        }

        if(nums[len-1] > nums[len-2]){
            return len-1;
        }
        for(int i = 1; i < len -1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        return -1;
    }
}
