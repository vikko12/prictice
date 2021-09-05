package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/4 23:30
 * @Description:
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int holder = 0;
        ListNode dummy = new ListNode();
        ListNode root = dummy;
        while(l1 != null || l2 != null || holder != 0){
            int cur = 0;
            if(l1 != null){
                cur += l1.val;
            }
            if(l2 != null){
                cur += l2.val;
            }
            cur += holder;
            holder = cur /10;
            cur = cur % 10;
            root.next = new ListNode(cur);

            //移动
            root = root.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        return dummy.next;
    }
}
