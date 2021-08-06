package com.vikko.demo.algorithm.year2021.month6;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: vikko
 * @Date: 2021/6/23 17:02
 * @Description:
 */
public class DetectCycle {

	public static void main(String[] args) {

	}
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode pos = head;
		while (pos != null){
			if(set.contains(pos)){
				return pos;
			}else {
				set.add(pos);
			}
			pos = pos.next;
		}
		return null;
	}
	public ListNode detectCycle2(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				ListNode third = head;
				while (third != slow){
					third = third.next;
					slow = slow.next;
				}
				return third;
			}
		}
		return null;
	}




}
