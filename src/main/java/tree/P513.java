package tree;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 *  
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 */
public class P513 {

    //【找树左下角的值】
    //题目已说明，root不等于null

    //深度
    int dep = 0;
    //此深度所在的第一个节点
    int node;

    public int findBottomLeftValue(TreeNode root) {
        node = root.val;
        sumLoop(root, 0);
        return node;
    }

    /*
     * 使用先序遍历，使用node保存第一个节点，使用dep保存深度
     * */
    private void sumLoop(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > dep) {
            node = root.val;
            dep = depth;
        }
        sumLoop(root.left, depth + 1);
        sumLoop(root.right, depth + 1);
    }


}
