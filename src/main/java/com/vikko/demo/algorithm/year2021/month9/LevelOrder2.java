package com.vikko.demo.algorithm.year2021.month9;

import com.google.common.collect.Lists;

import java.util.*;

public class LevelOrder2 {


    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offerFirst(root);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pollFirst();
            res.add(cur.val);

            if(cur.left != null){
                deque.offerLast(cur.left);
            }
            if(cur.right!= null){
                deque.offerLast(cur.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


}
