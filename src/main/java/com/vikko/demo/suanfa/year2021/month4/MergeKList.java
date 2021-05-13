package com.vikko.demo.suanfa.year2021.month4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: vikko
 * @Date: 2021/4/16 17:14
 * @Description:
 */
public class MergeKList {

	public static void main(String[] args) {

	}

	//基于堆实现
	public static ListNode mergeKLists2(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(ListNode::getVal));
		for (ListNode cur : lists) {
			while (cur != null){
				queue.offer(cur);
				cur = cur.next;
			}
		}
		ListNode dummyHead = new ListNode(), pre = dummyHead;
		while (pre != null){
			pre.next = queue.poll();
			pre = pre.next;
		}
		return dummyHead.next;
	}




	public static ListNode mergeKLists(ListNode[] lists) {

		return mergeK(lists,lists.length);

	}

	public static ListNode mergeK(ListNode[] lists, int size){
		if(size == 0){
			return null;
		}
		if(size == 1){
			return lists[0];
		}
		if(size == 2){
			return mergeTwoLists(lists[0], lists[1]);
		}
		return mergeTwoLists(mergeK(lists,size-1),lists[size-1]);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1), pre = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}

		if (l1 != null) {
			pre.next = l1;
		}
		if (l2 != null) {
			pre.next = l2;
		}
		return dummyHead.next;
	}

}
