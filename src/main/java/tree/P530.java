package tree;

/*
 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。

示例 :

输入:

   1
    \
     3
    /
   2

输出:
1

解释:
最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
注意: 树中至少有2个节点。
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
*/

public class P530 {

    //二叉搜索树的最小绝对差
    //即两个节点差的绝对值，，解法是按照中序遍历，二叉搜索树会变成递增序列
    static class Solution {

        //存储最小绝对差
        int min = Integer.MAX_VALUE;
        //存储当前节点的上一个节点的值，如果是第一个节点，则上一个节点的值为-1
        int prev = -1;

        /*使用【左 根 右】 方式遍历，搜索树则按照从小到大排序了,然后依次拿后面的减去前面的*/
        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                return min;
            }
            getMinimumDifference(root.left);
            //第一个节点不计算差值
            if (prev != -1) {
                min = Math.min(root.val - prev, min);
            }
            //保留当前节点作为前一个节点
            prev = root.val;
            getMinimumDifference(root.right);
            return min;
        }

    }

    public static void main(String[] args) {
        int minimumDifference = new Solution().getMinimumDifference(TreeNode.arrayToTree(new Integer[]{543, 384, 652, null, 445, null, 699}));
        System.out.println(minimumDifference);
    }


}
