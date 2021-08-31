package com.vikko.demo.algorithm.year2021.month8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: vikko
 * @Date: 2021/8/31 10:50
 * @Description:
 */
public class RotateRight {

	public ListNode rotateRight(ListNode head, int k) {

		if(head == null || head.next == null || k == 0){
			return head;
		}
		int len = 1;
		ListNode temp = head;
		while (temp.next != null){
			temp = temp.next;
			len++;
		}
		k %= len;
		if(k == 0){
			return head;
		}

		temp.next = head;
		for(int i = 0; i < len - k; i++){
			temp = temp.next;
		}

		ListNode newHead = temp.next;
		temp.next = null;

		return newHead;

	}


	public static void main(String[] args) {
		User cur = new User(1,"vikko");
		User temp = cur;
		cur = new User();
		System.out.println(temp);
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
	private Integer age;
	private String name;
}
