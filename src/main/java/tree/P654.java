package tree;

/**
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

 

示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
 

提示：

给定的数组的大小在 [1, 1000] 之间。

链接：https://leetcode-cn.com/problems/maximum-binary-tree

* */
public class P654 {


    static class Solution {

        //最大二叉树。参考P998 最大二叉树2
        /*
         * 解题思路： 按照题意，找到最大值作为根节点，左边递归为左子树，右边递归为右子树
         * */
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return buildTree(nums, 0, nums.length - 1);
        }

        //start 和 end都是闭区间
        private TreeNode buildTree(int[] nums, int start, int end) {
            if (start == end) {
                return new TreeNode(nums[start]);
            }
            if (start > end) {
                return null;
            }
            int maxIndex = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            TreeNode t = new TreeNode(nums[maxIndex]);
            t.left = buildTree(nums, start, maxIndex - 1);
            t.right = buildTree(nums, maxIndex + 1, end);
            return t;
        }

    }


}
