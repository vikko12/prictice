package com.vikko.demo.algorithm.year2021.month9;


/**
 * @author vikko
 * @date 2021/9/4 11:14
 * @Description: offer 27
 */
public class MirrorTree {

    public TreeNode mirrorTree( TreeNode root) {

        if (root == null){
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmpNode);

        return root;
    }
}
