package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author vikko
 * @date 2021/9/5 11:42
 * @Description:
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()){
            int count = deque.size();
            while (count > 0){
                TreeNode cur = deque.pollFirst();
                if(count == 1){
                    res.add(cur.val);
                }
                if(cur.left != null){
                    deque.offerLast(cur.left);
                }
                if(cur.right != null){
                    deque.offerLast(cur.right);
                }
                count--;
            }
        }
        return res;
    }

}
