package tree;

/*
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：

输入: 二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13

链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
* */
public class P538 {

    static class Solution {
        //把二叉搜索树转换为累加树
        //每个节点的值 = 当前值 + 所有值比他大的节点值和
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            js(root);
            return root;
        }


        int v = 0;

        /*
         * 使用【右 中 左】的方式遍历树,这样可以将值大的节点主键累积到v中
         *
         * 因为是二叉搜索树，如果采用【左 根 右】则是从小到大，采用【右 根 左】 则是从大到小
         * 既然能够从大到小，也就可以将数逐渐累积到前面的小数中
         * */
        private void js(TreeNode t) {
            if (t == null) {
                return;
            }
            js(t.right);
            //当前节点 += 前面所有比当前节点大的节点值
            t.val += v;
            //将当前节点的值累积到v中
            v = t.val;
            js(t.left);
        }

    }

    public static void main(String[] args) {

        TreeNode treeNode = new Solution().convertBST(TreeNode.arrayToTree(new Integer[]{2, 0, 3, -4, 1}));
        System.out.println(treeNode);
    }


}
