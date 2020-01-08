package tree;

/*
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 保证原始二叉搜索树中不存在新值。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

例如, 

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和 插入的值: 5
你可以返回这个二叉搜索树:

         4
       /   \
      2     7
     / \   /
    1   3 5
或者这个树也是有效的:

         5
       /   \
      2     7
     / \
    1   3
         \
          4

链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
*/
public class P701 {

    /*
     * 二叉搜索树中的插入操作
     *
     * */
    static class Solution {
        //比较简单，因为是二叉搜索树，直接查找插入进去即可
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode start = root;
            while (true) {
                if (start.val < val) {
                    if (start.right == null) {
                        start.right = new TreeNode(val);
                        return root;
                    } else {
                        start = start.right;
                    }
                }
                if (start.val > val) {
                    if (start.left == null) {
                        start.left = new TreeNode(val);
                        return root;
                    } else {
                        start = start.left;
                    }


                }
            }
        }
    }


}