package com.vikko.demo.algorithm.year2021.month5;

/**
 * @author: vikko
 * @Date: 2021/5/18 19:12
 * @Description:
 */
public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode cur = dummyHead;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int curVal = cur.next.val;
				while (cur.next != null && curVal == cur.next.val) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummyHead.next;
	}

	public ListNode deleteDuplicatesOfficial(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0, head);
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;
				while (cur.next != null && cur.next.val == x) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}

		return dummy.next;
	}

	/**
	 * distinct
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesDistinct(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, cur = head;
		while (cur!=null && cur.next != null){
			if(cur.val == cur.next.val){
				int curVal = cur.val;
				while (cur.next != null && cur.next.val == curVal){
					cur = cur.next;
					pre.next = cur;
				}
			}else {
				pre = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	public ListNode deleteDuplicatesSelf(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode  cur = dummy;
		while (cur.next != null && cur.next.next != null){
			if(cur.next.val == cur.next.next.val){
				int curVal = cur.next.val;
				while (cur.next != null && cur.next.val == curVal){
					cur.next = cur.next.next;
				}
			}else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

}
