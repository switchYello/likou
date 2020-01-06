package tree;

/*
给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

二叉搜索树保证具有唯一的值。

 

示例 1：

输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
输出：32
示例 2：

输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
输出：23
 

提示：

树中的结点数量最多为 10000 个。
最终的答案保证小于 2^31。

* */

// 二叉搜索树的范围和
public class P938 {
    static class Solution {
        //注意root是搜索二叉树
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            //大于R的忽略右子树，只循环小于等于R的右子树
            if (root.val <= R) {
                sum += rangeSumBST(root.right, L, R);
            }
            //小于L的忽略左子树，只循环大于等于L的左子树
            if (root.val >= L) {
                sum += rangeSumBST(root.left, L, R);
            }

            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.arrayToTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
        int i = new Solution().rangeSumBST(t, 7, 15);
        System.out.println(i);


    }


}
