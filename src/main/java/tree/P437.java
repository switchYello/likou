package tree;

import java.util.LinkedList;
import java.util.Queue;

public class P437 {
/*
    给定一个二叉树，它的每个结点都存放着一个整数值。
    找出路径和等于给定数值的路径总数。
    路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
    示例：

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

    返回 3。和等于 8 的路径有:

    1.  5 -> 3
    2.  5 -> 2 -> 1
    3.  -3 -> 11

* */


    static class Solution {

        /*
         *
         * 计算以root为根节点有多少条路满足相加等于sum*/
        private static int pathSum2(TreeNode root, final int sum) {
            if (root == null) {
                return 0;
            }
            int count = 0;
            if (root.val == sum) {
                count++;
            }
            count += pathSum2(root.left, sum - root.val);
            count += pathSum2(root.right, sum - root.val);
            return count;
        }

        /*
         *采用非递归先序遍历，将树中每个节点都作为一棵独立的树传入pathSum2
         * */
        public static int pathSum(TreeNode root, final int sum) {
            int i = 0;
            Queue<TreeNode> list = new LinkedList<>();
            list.add(root);
            while (true) {
                TreeNode poll = list.poll();
                if (poll == null) {
                    return i;
                }
                if (poll.left != null) {
                    list.offer(poll.left);
                }
                if (poll.right != null) {
                    list.offer(poll.right);
                }
                i += pathSum2(poll, sum);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        int i = Solution.pathSum(root, 8);
        System.out.println(i);

    }


}
