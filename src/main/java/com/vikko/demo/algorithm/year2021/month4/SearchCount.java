package com.vikko.demo.algorithm.year2021.month4;

public class SearchCount {

    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        System.out.println(search(a, 7));
    }

    public static int search(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int mid = left + (right - left) >> 1;
            if(nums[mid]>=target)
                right=mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        while(left<nums.length&&nums[left++]==target)
            count++;
        return count;
    }
}
