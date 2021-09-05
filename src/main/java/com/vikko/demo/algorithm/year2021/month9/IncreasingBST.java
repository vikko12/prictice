package com.vikko.demo.algorithm.year2021.month9;

import lombok.*;

/**
 * @author vikko
 * @date 2021/9/4 16:14
 * @Description:
 */
public class IncreasingBST {


    /**
     * 递增顺序查找树
     *
     * @param root
     * @return
     */
    TreeNode dummy = new TreeNode(0);
    TreeNode real = dummy;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        increasingBST(root.left);
        real.right = new TreeNode(root.val);
        real = real.right;
        increasingBST(root.right);
        return dummy.right;
    }
}
