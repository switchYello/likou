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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        //真实同值路径 = 同值节点数 - 1
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            search(root);
            return max - 1;
        }

        int max = 0;

        //返回值以root为起点的最大连接节点数
        int search(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = search(root.left);
            int right = search(root.right);
            int pLeft = 0, pRight = 0;
            if (root.left != null && root.left.val == root.val) {
                pLeft = left;
            }
            if (root.right != null && root.right.val == root.val) {
                pRight = right;
            }
            max = Math.max(max, 1 + pLeft + pRight);
            return 1 + Math.max(pLeft, pRight);
        }

        /*
         * 官方答案
         * */
        int ans;

        //此返回值为以root为起点最大同值长度
        public int arrowLength(TreeNode node) {
            if (node == null) return 0;
            int left = arrowLength(node.left);
            int right = arrowLength(node.right);
            int arrowLeft = 0, arrowRight = 0;
            if (node.left != null && node.left.val == node.val) {
                arrowLeft += left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                arrowRight += right + 1;
            }
            ans = Math.max(ans, arrowLeft + arrowRight);
            return Math.max(arrowLeft, arrowRight);
        }


        public static void main(String[] args) {
/*            TreeNode t = new TreeNode(1);
            t.right = new TreeNode(1);
            t.right.left = new TreeNode(1);
            t.right.right = new TreeNode(1);

            t.right.left.left = new TreeNode(1);
            t.right.left.right = new TreeNode(1);

            t.right.right.left = new TreeNode(1);
            t.right.right.right = new TreeNode(1);*/

            TreeNode t = new TreeNode(1);
            t.left = new TreeNode(4);
            t.right = new TreeNode(5);

            t.left.left = new TreeNode(4);
            t.left.right = new TreeNode(4);

            t.right.left = new TreeNode(5);

            System.out.println(new Solution().longestUnivaluePath(t));

        }


    }


}
