package com.vikko.demo.algorithm.year2021.month8;

/**
 * @author: vikko
 * @Date: 2021/9/2 10:11
 * @Description:
 */
public class GetKthFromEnd {

	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode fast = head, slow = head;
		while (fast != null){
			for(int i = 0; i < k; i++){
				fast = fast.next;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
