package tree;

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

* */

public class P110 {


    static class Solution {

        boolean flag = true;

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            //递归过程中有一个子循环返回false，将导致整个调用链返回false
            //返回true则继续调用
            if (!flag) {
                return false;
            }
            //这里会先递归计算左树，如果第一颗左树不满足，则 &&后面就不会执行
            return isBalanced(root.left) && isBalanced(root.right) && Math.abs(deple(root.left) - deple(root.right)) <= 1;
        }


        //计算给定树的最大深度
        private int deple(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            int depthLeft = deple(treeNode.left);
            int depthRight = deple(treeNode.right);

            if (Math.abs(depthLeft - depthRight) > 1) {
                flag = false;
            }
            return Math.max(depthLeft, depthRight) + 1;
        }


    }


}
