package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/4 14:25
 * @Description:
 */
public class PathSum3 {

    int pathnumber = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        help(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathnumber;
    }


    public void help(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            pathnumber++;
        }
        help(root.left, sum);
        help(root.right, sum);
    }

}
