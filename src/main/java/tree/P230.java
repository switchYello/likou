package tree;

import java.util.*;

/*
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
* */
public class P230 {

    //二叉搜索树中第K小的元素
    //要点是二叉搜索树，中序遍历是递增的
    static class Solution {

        //题目说明假定k一定存在
        public int kthSmallest(TreeNode root, int k) {
            loop(root);
            return list.get(k - 1);
        }

        List<Integer> list = new ArrayList<>();

        private void loop(TreeNode root) {
            if (root == null) {
                return;
            }
            loop(root.left);
            list.add(root.val);
            loop(root.right);
        }

        //非递归，左根右中序遍历，且查找到第k个时函数返回
        private int findK(TreeNode root, int k) {
            Set<TreeNode> set = new HashSet<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.push(root);
            while (!deque.isEmpty()) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null || set.remove(poll)) {
                    if (k-- == 1) {
                        return poll.val;
                    }
                    continue;
                }

                if (poll.right != null) {
                    deque.push(poll.right);
                }
                deque.push(poll);
                if (poll.left != null) {
                    deque.push(poll.left);
                }
                set.add(poll);
            }
            return -1;
        }


    }


}
