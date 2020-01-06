package tree;

/*
    给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

示例 1:

输入:
    1
   / \
  0   2

  L = 1
  R = 2

输出:
    1
      \
       2
示例 2:

输入:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

输出:
      3
     /
   2
  /
 1

* */
public class P669 {


    static class Solution {
        // 修剪二叉搜索树
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return root;
            }

            //如果当前根节点在范围的右边，则忽略左边节点
            while (root.val < L) {
                root = root.right;
                return trimBST(root, L, R);
            }
            //如果当前节点在范围左边，则忽略右边节点
            while (root.val > R) {
                root = root.left;
                return trimBST(root, L, R);
            }

            //当前节点在范围中间,修剪左右子树
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);

            return root;
        }
    }


}
