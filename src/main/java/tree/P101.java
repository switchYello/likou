package tree;

/*
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

链接：https://leetcode-cn.com/problems/symmetric-tree
* */
public class P101 {


    /*
     * 判断树是否是镜像对称的
     * 解法1.反转右子树，比较左右子树相同
     * 解法2，使用左根右 和 右根左 分别遍历一次，两次结果要相同，包括null节点的位置
     * 解法3，将解法2中的遍历同时进行，发现不同能立刻停止遍历
     * */
    static class Solution {
        //先翻转右树
        //在比较左右相同
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            jingxiang(root.right);
            return sameTree(root.left, root.right);
        }

        //翻转树
        private void jingxiang(TreeNode root) {
            if (root != null) {
                jingxiang(root.left);
                jingxiang(root.right);
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }

        //比较两个树相同
        private boolean sameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            return t1.val == t2.val && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
        }


    }

}
