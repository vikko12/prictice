package com.vikko.demo.algorithm.year2021.month8;


/**
 * @author: vikko
 * @Date: 2021/8/26 11:36
 * @Description:
 */
public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		ListNode a = headA, b = headB;
		while (a != b){
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;

	}

}
