package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

示例 1:

输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
解释:
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
注意：

节点值的范围在32位有符号整数范围内。
* */
public class P637 {
    static class Solution {
        //普通层次遍历
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> avg = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                long sum = 0;
                int size = queue.size();
                //每次取出一层数据，计算总数/size
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.remove();
                    sum += poll.val;
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                avg.add(sum * 1.0 / size);
            }
            return avg;

        }
    }


}
