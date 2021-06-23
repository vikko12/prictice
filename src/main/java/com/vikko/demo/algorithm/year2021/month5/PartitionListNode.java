package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/14 18:00
 * @Description:
 */
public class PartitionListNode {

	public ListNode partition(ListNode head, int x) {
		ListNode smallHead = new ListNode(0);
		ListNode dummySmall= smallHead;

		smallHead.next = head;
		ListNode largeHead = new ListNode(0);
		ListNode dummyLarge= largeHead;
		while (head != null){
			if(head.val < x){
				smallHead.next = head;
				smallHead = smallHead.next;
			}else {
				largeHead.next = head;
				largeHead = largeHead.next;
			}
			head = head.next;
		}
		largeHead.next = null;
		smallHead.next= dummyLarge.next;
		return dummySmall.next;
	}


}
