package com.vikko.demo.algorithm.year2021.month5;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> subset = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        backTracking(nums, 0);
        return res;
    }
    public static void backTracking(int[] nums, int startIndex) {
        // 回溯树中的所有节点都要加入到结果集合中
        res.add(new ArrayList<>(subset));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            backTracking(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2});
        System.out.println(subsets);
    }
}
