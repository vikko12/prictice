package com.vikko.demo.algorithm.year2021.month9;

import java.util.List;

/**
 * @author vikko
 * @date 2021/9/5 14:32
 * @Description:
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode o = head;
        ListNode p = head.next;
        ListNode e = p;
        while (o.next != null && e.next != null){
            o.next = e.next;
            o = o.next;

            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }

}
