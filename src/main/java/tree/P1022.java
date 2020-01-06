package tree;

/*
给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。

对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

以 10^9 + 7 为模，返回这些数字之和。

示例：


输入：[1,0,1,0,1,0,1]
输出：22
解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

提示：

树中的结点数介于 1 和 1000 之间。
node.val 为 0 或 1 。

链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers

* */
public class P1022 {

    //从根到叶的二进制数之和
    static class Solution {
        public int sumRootToLeaf(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //包装long类型，作为总数。
            LongWrap sum = new LongWrap();
            loop(root, 0, sum);
            return (int) sum.value;
        }

        /**
         * @param root    需要遍历的树
         * @param content 上个节点移位叠加的值
         * @param sum     总数
         */
        private static void loop(TreeNode root, int content, LongWrap sum) {

            //如果是叶子节点，则将当前值叠加到上层值中，并统计到sum中
            if (root.left == null && root.right == null) {
                sum.value += (content | root.val);
            }

            //如果不是叶子节点，将当前节点值叠加到content中，并移位计算下一个数据
            if (root.left != null) {
                loop(root.left, (content | root.val) << 1, sum);
            }

            if (root.right != null) {
                loop(root.right, (content | root.val) << 1, sum);
            }
        }

        //包装long类型，递归参数时是值传递
        private static class LongWrap {
            long value = 0;
        }

    }

    public static void main(String[] args) {
        int content = 0;
        int c = 1;
        System.out.println(content | c);

    }


}
