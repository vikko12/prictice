package com.vikko.demo.suanfa.year2021.month4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * @author: vikko
 * @Date: 2021/4/20 10:59
 * @Description:
 */
public class LevelOrder {

	List<List<Integer>> result = new ArrayList<>();

	/**
	 * todo 未完成
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<TreeNode> nodes = Collections.singletonList(root);
		while (!CollectionUtils.isEmpty(nodes)){
			nodes = getLevelResult(nodes);
		}
		return null;
	}

	private List<TreeNode> getLevelResult(List<TreeNode> nodes){
		if(CollectionUtils.isEmpty(nodes)){
			return Collections.emptyList();
		}
		List<TreeNode> children = new ArrayList<>();
		List<Integer> valList = new ArrayList<>();
		nodes.stream().forEach(node->{
			children.add(node);
			valList.add(node.val);
		});
		result.add(valList);
		return children;
	}

}
