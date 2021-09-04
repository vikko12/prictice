package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author: vikko
 * @Date: 2021/9/3 17:29
 * @Description:
 */
public class IsSubstructure {

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(A == null || B == null){
			return false;
		}
		return dfs(A, B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
	}

	/**
	 * 比较当前两个节点是不是相同结构
	 * @param A
	 * @param B
	 * @return
	 */
	private boolean dfs(TreeNode A, TreeNode B){
		if(B == null){
			return true;
		}
		if(A == null){
			return false;
		}
		return A.val == B.val && dfs(A.left,B.left) && dfs(A.right,B.right);
	}

}
