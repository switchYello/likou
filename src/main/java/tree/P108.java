package tree;

/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

* */
public class P108 {

    static class Solution {
        //将数组存储为全局
        int[] nums;

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            this.nums = nums;
            return sortedArrayToBST(0, nums.length - 1);
        }

        //开始索引最小值为0，结束索引最大值为muns.length - 1，为左闭右闭区间
        //每次找到中间的数作为node，左右两边作为左右子树递归
        private TreeNode sortedArrayToBST(int start, int end) {
            int mid = (start + (end - start +1 ) / 2);

            TreeNode node = new TreeNode(nums[mid]);
            if (start != mid) {
                node.left = sortedArrayToBST(start, mid - 1);
            }
            if (mid != end) {
                node.right = sortedArrayToBST(mid + 1, end);
            }
            return node;
        }


        public static void main(String[] args) {
            int[] params = {-10, -3, 0, 5, 9};
            new Solution().sortedArrayToBST(params);
        }


    }


}
