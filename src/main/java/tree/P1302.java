package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
给你一棵二叉树，请你返回层数最深的叶子节点的和。

 

示例：



输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
 

提示：

树中节点数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。

链接：https://leetcode-cn.com/problems/deepest-leaves-sum
* */
public class P1302 {

    //层数最深叶子节点的和
    static class Solution {
        /*
         * 解题思路是按照层次遍历，得到最后一层的节点和
         * */
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sum += poll.val;
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                if (queue.isEmpty()) {
                    return sum;
                }
            }
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {

        int i = new Solution().deepestLeavesSum(TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}));
        System.out.println(i);

    }

}
