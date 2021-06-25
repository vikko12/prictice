package com.vikko.demo.algorithm.year2021.month6;

/**
 * @author: vikko
 * @Date: 2021/6/23 17:28
 * @Description:
 */
public class HasCycle {

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null){
			if(fast == slow){
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

}
