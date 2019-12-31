package tree;

/*
    给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
    注意：两个节点之间的路径长度由它们之间的边数表示。
    示例 1:
    输入:

                  5
                 / \
                4   5
               / \   \
              1   1   5
    输出:
    2
    示例 2:

    输入:

                  1
                 / \
                4   5
               / \   \
              4   4   5
    输出:
    2

* */
public class P687 {

    static class A {
        TreeNode node;
        int count;
    }

    private static class MyTreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int count;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return max;
            }
            int[] ints = longestUnivaluePathRun(root);
            max = Math.max(max, ints[0] + ints[1]);
            return max;
        }

        //得到树的左右两边分量
        private int[] longestUnivaluePathRun(TreeNode root) {
            int sum = 0, L = 0, R = 0;
            if (root.left != null) {
                int[] left = longestUnivaluePathRun(root.left);
                L = left[0] + left[1];
                if (root.left.val == root.val) {
                    //如果子树左右两边有一个小于1的，则忽略那个小于1的
                    if (left[0] < 1 || left[1] < 1) {
                        sum += 1;
                        sum += Math.max(left[0], left[1]);
                    } else {
                        sum += L;
                    }
                }
            }

            if (root.right != null) {
                int[] right = longestUnivaluePathRun(root.right);
                R = right[0] + right[1];
                if (root.right.val == root.val) {
                    if (right[0] < 1 || right[1] < 1) {
                        sum += 1;
                        sum += Math.max(right[0], right[1]);
                    } else {
                        sum += R;
                    }
                }
            }
            max = Math.max(sum, max);
            return new int[]{L, R};
        }


    }


}
