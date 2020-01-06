package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*

请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。

提示：
给定的两颗树可能会有 1 到 100 个结点

链接：https://leetcode-cn.com/problems/leaf-similar-trees

* */
public class P872 {

    // 叶子相似的树
    static class Solution {

        //判断这两棵树的叶序是否相同,相同则返回true
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            Queue<Integer> yz = new LinkedList<>();
            getYz(root1, yz);
            //先序遍历root2，将叶子节点和root1的比较
            Deque<TreeNode> list = new LinkedList<>();
            list.add(root2);
            while (!list.isEmpty()) {
                TreeNode poll = list.poll();
                //拿到叶子节点，如果和队列里的不一致则不需要继续执行下去
                if (poll.left == null && poll.right == null && yz.poll() != poll.val) {
                    return false;
                }
                if (poll.right != null) {
                    list.push(poll.right);
                }
                if (poll.left != null) {
                    list.push(poll.left);
                }
            }
            return yz.isEmpty();

        }

        //先序遍历root，将叶子节点存入队列中
        //要保证参数root不等于null
        private void getYz(TreeNode root, Queue<Integer> yz) {
            if (root.left == null && root.right == null) {
                yz.offer(root.val);
            }
            if (root.left != null) {
                getYz(root.left, yz);
            }
            if (root.right != null) {
                getYz(root.right, yz);
            }
        }


    }


}
