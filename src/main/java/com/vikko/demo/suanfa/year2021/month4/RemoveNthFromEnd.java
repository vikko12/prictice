package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/12 13:44
 * @Description:
 */
public class RemoveNthFromEnd {

	public static void main(String[] args) {

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode realHead = new ListNode(0, head);
		ListNode fast = realHead;
		ListNode slow = realHead;
		int i = 0;
		while (fast != null) {
			//先跑的逻辑写在同一个循环里
			if (i <= n) {
				fast = fast.next;
				i++;
				continue;
			}
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return realHead.next;
	}

}
