package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author: vikko
 * @Date: 2021/9/3 17:28
 * @Description:
 */
public class ReversePrint {

	public int[] reversePrint(ListNode head) {
		ListNode cur = head;
		int count = 0;
		while(cur != null){
			cur = cur.next;
			count++;
		}
		int[] res = new int[count];
		for(int i = count - 1; i>= 0; i--){
			res[i] = head.val;
			head = head.next;
		}
		return res;
	}

}
