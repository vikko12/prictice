package com.vikko.demo.algorithm.year2021.month8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: vikko
 * @Date: 2021/8/25 16:03
 * @Description:
 */
public class ZigZagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null){
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		boolean orderFlag = false;
		deque.offer(root);
		while (!deque.isEmpty()){
			int count = deque.size();
			List<Integer> items = new ArrayList<>();
			while (count > 0){
				TreeNode cur = deque.poll();
				if(cur.right != null){
					deque.offerLast(cur.right);
				}
				if(cur.left != null){
					deque.offerLast(cur.left);
				}
				count--;
				if(orderFlag){
					items.add(cur.val);
				}else {
					items.add(0,cur.val);
				}
			}
			orderFlag = !orderFlag;
			res.add(items);
		}
		return res;
	}

}
