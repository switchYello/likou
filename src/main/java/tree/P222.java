package tree;

import tool.Check;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 示例:
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 */

public class P222 {

    //方法1，通用递归方法，需要遍历所有节点
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /*
     *这里查看了题解，看到一种更好的方式
     *他是分别求出左右子树的向左的深度，如果深度一致，能得出左树是满的，如果深度不一致能得出右树是满的
     * */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        //获取左树深度
        int leftDepth = getDepth(root.left);
        //获取右树深度
        int rightDepth = getDepth(root.right);

        //根据深度是否相同，来得到是左树还是右树是不满的，，满的树可以通过公式计算
        if (leftDepth == rightDepth) {
            return 1 + (1 << leftDepth) - 1 + countNodes2(root.right);
        } else {
            return 1 + (1 << rightDepth) - 1 + countNodes2(root.left);
        }
    }

    private int getDepth(TreeNode tree) {
        int depth = 0;
        TreeNode root = tree;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }


    public static void main(String[] args) {

        int countNodes = new P222().countNodes2(TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Check.checkTrue(countNodes == 9);
    }


}

