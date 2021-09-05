package com.vikko.demo.algorithm.year2021.month9;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指offer34
 */
public class PathSum {

    Deque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }


    public void dfs(TreeNode root, int target){
        if(root == null){
            return;
        }
        target -= root.val;
        path.offerLast(root.val);
        if(target == 0 && root.left == null && root.right == null){
            //todo 为啥不要return
            /**
             * 如果在这里就return了，那后面一次的collector.remove(collector.size() - 1);就执行不到了，总的回退次数就少了一次，就会导致后面答案总是比前面多一个数。
             */
            res.add(new ArrayList<>(path));
        }

        dfs(root.left,target);
        dfs(root.right,target);
        path.pollLast();
    }

}
