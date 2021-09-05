package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/4 14:27
 * @Description:
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return helper(root, targetSum);
    }

    public boolean helper(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        targetSum -= root.val;
        return helper(root.left, targetSum) || helper(root.right, targetSum);
    }
}
