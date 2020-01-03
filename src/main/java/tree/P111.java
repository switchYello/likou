package tree;

/*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
示例:
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
* */

import java.util.LinkedList;

public class P111 {

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int minLeft = minDepth(root.left);
            int minRight = minDepth(root.right);
            if (minLeft == 0) {
                return 1 + minRight;
            }
            if (minRight == 0) {
                return 1 + minLeft;
            }
            return 1 + Math.min(minLeft, minRight);
        }


        /*
         * 题解答案2，遍历全部节点，比较最小深度
         * */
        public int minDepth2(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) {
                return 0;
            } else {
                stack.add(new Pair<>(root, 1));
            }

            int min_depth = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                //这里使用了pollLast(),,则为从上到下，从右到左遍历
                Pair<TreeNode, Integer> current = stack.pollLast();
                root = current.getKey();
                int current_depth = current.getValue();
                if ((root.left == null) && (root.right == null)) {
                    //发现叶子节点，则和当前保存的深度比对
                    min_depth = Math.min(min_depth, current_depth);
                }
                if (root.left != null) {
                    stack.add(new Pair<>(root.left, current_depth + 1));
                }
                if (root.right != null) {
                    stack.add(new Pair<>(root.right, current_depth + 1));
                }
            }
            return min_depth;
        }


        /*
         * 题解答案3，按照层次遍历，碰到的第一个叶子节点，他的深度为最小深度
         * */

        public int minDepth3(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) {
                return 0;
            } else {
                stack.add(new Pair<>(root, 1));
            }

            int current_depth = 0;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> current = stack.poll();
                root = current.getKey();
                current_depth = current.getValue();
                //碰到第一个叶子节点则停止
                if ((root.left == null) && (root.right == null)) {
                    break;
                }
                if (root.left != null) {
                    stack.add(new Pair<>(root.left, current_depth + 1));
                }
                if (root.right != null) {
                    stack.add(new Pair<>(root.right, current_depth + 1));
                }
            }
            return current_depth;
        }


    }

    public static void main(String[] args) {

        int i = new Solution().minDepth(TreeNode.arrayToTree(new Integer[]{1, 2}));
        System.out.println(i);

    }

}
