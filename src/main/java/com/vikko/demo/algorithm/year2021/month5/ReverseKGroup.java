package com.vikko.demo.algorithm.year2021.month5;


/**
 * @author: vikko
 * @Date: 2021/5/12 10:46
 * @Description:
 */
public class ReverseKGroup {


	public static void main(String[] args) {

	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode left = dummy, right = head;
		int cnt = 0;
		while(right != null){
			cnt++;
			right = right.next;
			if(cnt % k == 0){
				left = reverse(left, right);
			}
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode left, ListNode right){
		ListNode pre = left, cur = left.next;
		ListNode first = pre, last = cur;
		while(cur != right){
			ListNode nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		first.next = pre;
		last.next = right;
		return last;
	}

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

}
