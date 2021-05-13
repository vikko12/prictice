package com.vikko.demo.suanfa.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/15 15:17
 * @Description:
 */
public class SwapPairs {

	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}

	public ListNode swapPairsWrong(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = head.next;
		newHead.next = head;
		head.next = swapPairs(head.next.next);
		return newHead;
	}



}
