package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/5 15:15
 * @Description:
 */
public class SortArray {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        return quickSort(nums, 0, nums.length -1);
    }

    private int[] quickSort(int[] nums, int low, int high){
        if(low < high){
            int partition = partition(nums, low, high);
            quickSort(nums, low, partition-1);
            quickSort(nums, partition + 1, high);
        }
        return nums;
    }

    private int partition(int[] nums, int left, int right){
        int i = left, j = right;
        int temp = nums[i];
        while (i < j){
            while (i < j && nums[j] > temp){
                j--;
            }
            if(i < j){
               nums[i] = nums[j];
               i++;
            }
            while (i < j && nums[i] < temp){
                i++;
            }
            if(i<j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;
        return i;
    }

}
