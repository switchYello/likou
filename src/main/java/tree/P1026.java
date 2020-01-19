package tree;

/**
 * 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 每个节点的值介于 0 到 100000 之间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 */
public class P1026 {

    int max = 0;

    //差值可能是大数间减小数，也可能是小数减大数，这里考虑两种肯可能
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        val(root, root.val, root.val);
        return max;
    }

    /**
     * 从顶向上递归调用每个子树，调用父树的最大节点和最小节点传入
     * 比较当前节点和最大节点，最小节点，能计算出最大差值
     */
    private void val(TreeNode root, int m, int n) {
        if (root == null) {
            return;
        }
        max = Math.max(max, m - root.val);
        max = Math.max(max, root.val - n);

        val(root.left, Math.max(m, root.val), Math.min(n, root.val));
        val(root.right, Math.max(m, root.val), Math.min(n, root.val));

    }


    public static void main(String[] args) {
        P1026 p = new P1026();
        TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{8, null, 1, 5, 6, 2, 4, 0, null, 7, 3});
        p.maxAncestorDiff(treeNode);
        System.out.println(p.max);

    }
}
