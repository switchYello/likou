package tree;

/*

    给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

    示例 :
    给定二叉树

              1
             / \
            2   3
           / \
          4   5
    返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

    注意：两结点之间的路径长度是以它们之间边的数目表示。

* */

public class P543 {

    static class Solution {
        //遍历所有子树，题目类似于P687
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            depth(root);
            return maxDiameter;
        }

        //保存最大直径，只需遍历一遍所有子树即可
        int maxDiameter = 0;

        //求最大深度
        private int depth(TreeNode t) {
            if (t == null) {
                return 0;
            }
            int leftDepth = depth(t.left);//左树最大深度 （节点数）
            int rightDepth = depth(t.right);//右树最大深度
            maxDiameter = Math.max(maxDiameter, (leftDepth + rightDepth + 1) - 1);//最大直径等于左右两边最大深度之和-1，左右深度+当前节点 = 总节点数，再-1得到路径长度
            return 1 + Math.max(leftDepth, rightDepth); // 当前树的最大深度等于Max（左右子树） + 1
        }

    }

}
