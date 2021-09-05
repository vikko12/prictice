package com.vikko.demo.algorithm.year2021.month9;

/**
 * @author vikko
 * @date 2021/9/4 15:13
 * @Description:
 */
public class Connect {

    /**
     * 链接 完美二叉树，上一层节点的next.left就是下一层right的next
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    /**
     * 任意二叉树，
     * @return
     */
    public Node connect2(Node root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);
        connect2(root.right);
        connect2(root.left);
        return root;
    }

    public Node getNext(Node root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
