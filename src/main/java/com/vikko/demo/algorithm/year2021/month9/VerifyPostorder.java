package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author vikko
 * @date 2021/9/4 23:46
 * @Description: offer 33
 */
public class VerifyPostorder {

    public static void main(String[] args) {
        int[] a = {1,3,2,6,5};
        verifyPostorder(a);
    }

    public static boolean verifyPostorder(int[] postorder) {
        // 单调栈使用，单调递增的单调栈
        Deque<Integer> deque = new ArrayDeque<>();
        int pervElem = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length - 1;i>=0;i--){
            // 左子树元素必须要小于递增栈被peek访问的元素(root或者right)，否则就不是二叉搜索树
            if (postorder[i] > pervElem){
                return false;
            }
            while (!deque.isEmpty() && postorder[i] < deque.peekFirst()){
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                pervElem = deque.pop();
                System.out.println("preElem   = " + pervElem);
            }
            // 这个新元素入栈
            deque.addFirst(postorder[i]);
        }
        return true;
    }
    
}
