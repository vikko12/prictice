package com.vikko.demo.algorithm.year2021.month4;

/**
 * @author: vikko
 * @Date: 2021/4/7 11:03
 * @Description:
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
//		int[] ints = new int[20];
//		System.out.println(Arrays.toString(ints));
		String s = "sssss";
		int a = s.charAt(1);
		System.out.println(a);
		System.out.println(s.charAt(1));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1), pre = dummyHead;
		int carry = 0;
		while (l1 != null || l2 != null || carry!= 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			pre.next = new ListNode(carry % 10);
			carry = carry / 10;
			pre = pre.next;
		}
		return dummyHead.next;
	}


}


