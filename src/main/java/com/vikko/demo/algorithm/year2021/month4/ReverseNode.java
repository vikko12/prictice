package com.vikko.demo.algorithm.year2021.month4;

import com.vikko.demo.algorithm.year2021.month5.ReverseKGroup;
import lombok.Data;

/**
 * @see ReverseKGroup
 */
public class ReverseNode {

    /**
     * 1.初始化 pre 和cur
     * 2.while循环
     * 3.定义next，next只是为了移动指针（虚幻体外层不做定义），类似于temp的概念
     * 4.更改cur的指向
     * 5.pre和cur移动一个单元
     * @param head
     * @return
     */
	public static ListNode reverseList(ListNode head) {
		//初始化。此时不包含next
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			//定义next，做移动指针
			ListNode nextForMovePoint = curr.next;
			//反转
			curr.next = prev;

			//移动指针
			prev = curr;
			curr = nextForMovePoint;
		}
		return prev;
	}


	public ListNode reverseBetween(
			ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 1; i < left; i++) {
			pre = pre.next;
		}
		head = pre.next;
		for (int i = left; i < right; i++) {
			ListNode nex = head.next;
			head.next = nex.next;
			nex.next = pre.next;
			pre.next = nex;
		}
		return dummy.next;
	}

	public static ListNode reverseList2(ListNode head) {
	    ListNode pre = null, cur = head;
	    while (cur != null){
          ListNode nextForMove = cur.next;
          cur.next = pre;
          pre = cur;
          cur = nextForMove;
      }
	    return pre;
	}

}


@Data
class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
