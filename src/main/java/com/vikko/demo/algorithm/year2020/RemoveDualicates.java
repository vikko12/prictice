package com.vikko.demo.algorithm.year2020;

/**
 * @author vikko
 * @date 2020/6/23 18:22
 */
public class RemoveDualicates {
    public static void main(String[] args) {
        int[] array = {10,10,11,1,2,2,3,3,5};
        pop(array);
    }
    public static void pop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len -i -1; j++) {
                if (nums[j+1] <= nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for (int num : nums) {

        System.out.print(num + ", ");
        }
    }

    public int removeDuplicates(int[] nums) {
        // 使用双指针
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        //i的位置是清空好的（nums[i]也是最大），用j来判断跟nums[i]的大小关系
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
}
