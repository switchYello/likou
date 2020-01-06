package tree;

/*
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
* */

public class P404 {

    static class Solution {
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            js(root);
            return sum;
        }

        //先序遍历，将做叶子的值叠加到sum中
        private void js(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            js(root.left);
            js(root.right);
        }
    }
}
