package tree;

/*

给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1:

输入:
    2
   / \
  2   5
     / \
    5   7

输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。
示例 2:

输入:
    2
   / \
  2   2

输出: -1
说明: 最小的值是 2, 但是不存在第二小的值。

链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
* */
public class P671 {
    static
    class Solution {
        // 二叉树中第二小的节点
        /*
         * 题目已知的是1.每个节点存在两个子节点或没有子节点。2.如果存在两个子节点，则父节点的值小于子节点的
         * 根据已知条件能判断出，root节点的值是最小的
         * */
        public int findSecondMinimumValue(TreeNode root) {
            //单独处理null
            if (root == null) {
                return -1;
            }
            return secondMin(root, root.val);
        }

        //找到树中 值不等于notEqual的值中最小的，没找到则返回-1
        int secondMin(TreeNode node, int notEqual) {
            int min = -1;
            if (node == null) {
                return min;
            }
            //相等则取子树的最小值
            if (node.val == notEqual) {
                //左子树最小
                int left = secondMin(node.left, node.val);
                //右子树最小
                int right = secondMin(node.right, node.val);
                if (left == -1) {
                    return right;
                }
                if (right == -1) {
                    return left;
                }
                return Math.min(left, right);
            } else {
                return node.val;
            }
        }

    }
}
