package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

* */
public class P226 {


    static class Solution {

        //递归解法
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }

            invertTree(root.left);
            invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }

        /*
         * 遍历解法，用什么遍历方式都可以，只要遍历所有节点，将他的左右节点交换即可
         * */
        public TreeNode invertTree2(TreeNode root) {
            if (root == null) return null;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            return root;
        }


    }


}
