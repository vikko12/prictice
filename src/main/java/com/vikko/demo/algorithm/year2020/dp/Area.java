package com.vikko.demo.algorithm.year2020.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author vikko
 * @date 2020/6/23 19:17
 */
public class Area {
    public static void main(String[] args) {
        Integer[] arr = {1,3,6};
        Arrays.sort(arr, (a, b)->a-b);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int a= 0; a < arr.length; a++){
            queue.offer(arr[a]);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
    public int largestRectangleArea(int[] heights) {

        return 0;
    }
}
