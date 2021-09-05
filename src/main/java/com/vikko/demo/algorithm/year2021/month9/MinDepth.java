package com.vikko.demo.algorithm.year2021.month9;

import com.vikko.demo.algorithm.year2021.month8.MaxDepth;

/**
 * @author vikko
 * @date 2021/9/5 12:04
 * @Description:
 * @see MaxDepth
 */
public class MinDepth {

    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        depth += 1;
        if(root.left == null && root.right == null){
            res = Math.min(res, depth);
        }
        dfs(root.left,depth);
        dfs(root.right,depth);
    }

}
