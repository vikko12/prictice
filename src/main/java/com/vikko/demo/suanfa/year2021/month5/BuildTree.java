package com.vikko.demo.suanfa.year2021.month5;

class BuildTree {
    private int pre=0;
    private int in=0;
    public TreeNode buildTree(int [] preorder, int [] inorder) {
        return buildTree(preorder,inorder,Integer.MAX_VALUE+1);
    }
    public TreeNode buildTree(int [] preorder,int [] inorder,long stop){
        //数组为空则返回null
        if(pre==preorder.length){
            return null;
        }
        //中序遍历序列数组顺序值等于终止值，则依次后移
        //表示此节点为空
        if(inorder[in]==stop){
            in++;
            return null;
        }
        //按照先序遍历顺序值新建节点
        int val=preorder[pre++];
        TreeNode root=new TreeNode(val);
        //建立左节点，终止值为当前节点值
        root.left=buildTree(preorder,inorder,val);
        //建立右节点，终止值为上一节点值
        root.right=buildTree(preorder,inorder,stop);
        //返回当前节点
        return root;
    }
}