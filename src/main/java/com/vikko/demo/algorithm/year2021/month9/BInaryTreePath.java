package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author vikko
 * @date 2021/9/4 16:04
 * @Description:
 */
public class BInaryTreePath {

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return res;
    }

    public void dfs(TreeNode root, String cur){
        if(root == null){
            return;
        }
        cur+=root.val;
        if(root.left == null && root.right == null){
            res.add(cur);
            return;
        }
        dfs(root.left,cur+"->");
        dfs(root.right,cur+"->");
    }
}
