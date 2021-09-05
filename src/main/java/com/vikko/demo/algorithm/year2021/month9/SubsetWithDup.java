package com.vikko.demo.algorithm.year2021.month9;

import java.util.*;

/**
 * @author vikko
 * @date 2021/9/5 13:18
 * @Description:
 */
public class SubsetWithDup {

    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList(set);
    }

    void dfs(int[] nums, int idx, List<Integer> path) {
        if (idx <= nums.length) {
            set.add(new ArrayList<>(path));
        } else {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
