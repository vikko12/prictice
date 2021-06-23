package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/16 16:57
 * @Description:
 */
public class MergeTwoLists {

	public static void main(String[] args) {

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
