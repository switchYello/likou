package tree;

import java.util.*;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

* */

public class P113 {

    static class Solution {

        /*
         * 暴力破解
         * 使用先序遍历，将每条路都记下来，筛选出满足条件的路
         * */
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> list = new LinkedList<>();
            Map<TreeNode, List<Integer>> map = new HashMap<>();
            list.add(root);
            map.put(root, Collections.singletonList(root.val));
            while (!list.isEmpty()) {
                TreeNode poll = list.poll();
                List<Integer> it = map.get(poll);
                //如果是到达叶子节点
                if (poll.left == null && poll.right == null) {
                    int s = 0;
                    for (Integer integer : it) {
                        s += integer;
                    }
                    if (s != sum) {
                        map.remove(poll);
                    }
                } else {
                    if (poll.left != null) {
                        list.offer(poll.left);
                        ArrayList<Integer> its = new ArrayList<>(it);
                        its.add(poll.left.val);
                        map.put(poll.left, its);
                    }
                    if (poll.right != null) {
                        list.offer(poll.right);
                        ArrayList<Integer> its = new ArrayList<>(it);
                        its.add(poll.right.val);
                        map.put(poll.right, its);
                    }
                    map.remove(poll);
                }
            }
            return new ArrayList<>(map.values());
        }

        /*
         * 这是看题解里别人的的一个方法，很棒
         * */
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> temp = new LinkedList<>();

        public List<List<Integer>> pathSum2(TreeNode root, int sum) {
            //除第一次外，以后root参数不会是null
            if (root == null) {
                return result;
            }
            //进入此层，将root的值放入列表
            temp.offer(root.val);
            if (root.left == null && root.right == null) {
                if (sum == root.val) {
                    //结果拷贝一份
                    result.add(new ArrayList<>(temp));
                }
            }

            if (root.left != null) {
                pathSum2(root.left, sum - root.val);
            }
            if (root.right != null) {
                pathSum2(root.right, sum - root.val);
            }
            //出方法，移除进入方法放入的元素
            temp.pop();
            return result;
        }
    }


}
