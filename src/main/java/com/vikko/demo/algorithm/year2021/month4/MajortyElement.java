package com.vikko.demo.algorithm.year2021.month4;

import java.util.Arrays;

public class MajortyElement {

    public static void main(String[] args) {
        int[] a = {1,2,2,2,2,4,5};
        System.out.println(find(a));
    }

    public static int find(int[] nums){
        Arrays.sort(nums);
        return nums[(nums.length) >> 1];
    }

    /**
     * 摩尔投票
     * @param nums
     * @return
     */
    public static int find2(int[] nums){
         int count = 0;
         Integer card = null;
         for(int num:nums){
             if(count == 0) card = num;
             count += (card == num)?1:-1;
         }
         return card;
    }
}
