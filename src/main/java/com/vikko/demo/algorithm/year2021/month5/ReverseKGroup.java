package com.vikko.demo.algorithm.year2021.month5;


/**
 * @author: vikko
 * @Date: 2021/5/12 10:46
 * @Description:
 */
public class ReverseKGroup {


	/**
	 * 两步反转
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}



	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode tail = head;
		for (int i = 0; i < k; i++) {
			//剩余数量小于k的话，则不需要反转。
			if (tail == null) {
				return head;
			}
			tail = tail.next;
		}
		// 第一次返回的newHead就是整个链表的head
		ListNode newHead = reverse(head, tail);
		//下一轮的返回的head就是上一轮的next，例如：1的next就是下一轮的6
		head.next = reverseKGroup(tail, k);

		return newHead;
	}

	/**
	 * 反转链表，tail不反转。
	 * 1-2-3-4-5-6-7-8  -----(head = 1, k = 3， tail = 4)----->   3-2-1  4-5-6-7-8
	 * @param head
	 * @param tail
	 * @return
	 */
	private ListNode reverse(ListNode head, ListNode tail) {
		ListNode pre = null;
		ListNode next = null;
		while (head != tail) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;

	}





}
