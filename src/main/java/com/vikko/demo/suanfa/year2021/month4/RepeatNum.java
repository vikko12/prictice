package com.vikko.demo.suanfa.year2021.month4;

import java.util.HashSet;
import java.util.Set;

public class RepeatNum {

    public static void main(String[] args) {
        int[] a = {10,3,6,7,8,7,1,1,1,1,1,1,1,1};
        System.out.println(findRepeat2(a));
    }

    public static int findRepeat(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if(!set.add(i)){
                return i;
            }
        }
        return -1;
    }

    public static int findRepeat2(int[] arr){
        int[] temp = new int[arr.length];
        int i = 0;
        while (i< arr.length){
            temp[arr[i]]++;
            if(temp[arr[i]] > 1){
                return arr[i];
            }
            i++;
        }
        return -1;

    }
}
