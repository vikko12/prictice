package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author vikko
 * @date 2021/9/5 15:42
 * @Description:
 */
public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++){
            int cur = nums[i % n];
            while(!deque.isEmpty() && nums[deque.peekLast()] < cur){
                res[deque.pollLast()] = cur;
            }
            if(i < n){
                deque.offer(i);
            }

        }
        return res;
    }

}
