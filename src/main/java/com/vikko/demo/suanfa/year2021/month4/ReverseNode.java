package com.vikko.demo.suanfa.year2021.month4;

import com.vikko.demo.suanfa.year2021.month5.ReverseKGroup;
import java.util.List;
import lombok.Data;

/**
 * @see ReverseKGroup
 */
public class ReverseNode {

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
        for(int i = 1; i < left; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = left; i < right; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
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
