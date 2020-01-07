package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。

示例 1：

输入：root = [1,2,3,4], x = 4, y = 3
输出：false
示例 2：

输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
示例 3：


输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false
 
提示：
二叉树的节点数介于 2 到 100 之间。
每个节点的值都是唯一的、范围为 1 到 100 的整数。

链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
* */
public class P993 {

    //二叉树的堂兄弟节点
    static
    class Solution {
        //注意题目已经说明了，树中的值都是不重复的
        //解法，按照层次遍历，处理每层时，去判断下一层的情况
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                //得到当前层的节点数量
                int size = queue.size();

                //记录找到x，y对应的父节点
                TreeNode xNode = null, yNode = null;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    TreeNode left = poll.left;
                    TreeNode right = poll.right;

                    if (left != null) {
                        queue.offer(left);
                        if (left.val == x) {
                            xNode = poll;
                        }
                        if (left.val == y) {
                            yNode = poll;
                        }
                    }

                    if (right != null) {
                        queue.offer(right);
                        if (right.val == x) {
                            xNode = poll;
                        }
                        if (right.val == y) {
                            yNode = poll;
                        }
                    }
                }
                //如果下一层没找到x和y则继续
                if (xNode == null && yNode == null) {
                    continue;
                }
                //如果找到x，找到y，且父节点不是同一个，则返回true
                if (xNode != null && yNode != null && xNode != yNode) {
                    return true;
                }
                //否则返回false
                return false;
            }
            //不会执行到这里
            throw new RuntimeException();
        }
    }


}
