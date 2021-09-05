package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/4 15:54
 * @Description: leetcode217
 */
public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }

    public int helper(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = helper(root.left, val);
        int r = helper(root.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }

}
