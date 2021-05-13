package com.vikko.demo.suanfa.year2021.month4;

class Solution {
    /**
     * pre记录前一节点
     */
    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
			if (root == null) {
				return;
			}
        dfs(root.left);
        if(pre != null){
            //记录最小
            res = Math.min(root.val-pre.val,res);
        }
        pre = root;
        dfs(root.right);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }