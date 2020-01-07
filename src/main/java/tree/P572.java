package tree;

/*
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。

链接：https://leetcode-cn.com/problems/subtree-of-another-tree
* */
public class P572 {

    //另一个树的子树
    static class Solution {
        //题目条件是s和t都不为null
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (treeIsEqual(s, t)) {
                return true;
            }
            if (s != null && isSubtree(s.left, t)) {
                return true;
            }
            if (s != null && isSubtree(s.right, t)) {
                return true;
            }
            return false;
        }

        //比较两个树完全相等
        private boolean treeIsEqual(TreeNode t, TreeNode t2) {
            if (t == null && t2 == null) {
                return true;
            }
            if (t == null) {
                return false;
            }
            if (t2 == null) {
                return false;
            }
            if (t.val != t2.val) {
                return false;
            }
            return treeIsEqual(t.left, t2.left) && treeIsEqual(t.right, t2.right);
        }

    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.arrayToTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode t2 = TreeNode.arrayToTree(new Integer[]{4, 1, 2});

        boolean subtree = new Solution().isSubtree(t1, t2);
        System.out.println(subtree);


    }


}
