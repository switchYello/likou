package tree;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */

public class P98 {

    //要点是中序遍历为升序排序
    public boolean isValidBST(TreeNode root) {
        return loop(root);
    }

    //记录遍历的最后一个值，但要使用long类型的来做
    long val = Long.MIN_VALUE;

    //    返回值表示是否是从小到大的
    private boolean loop(TreeNode root) {
        if (root == null) {
            return true;
        }
        //不用完全遍历树，如果发现子树返回false，直接返回false，不用继续执行
        boolean loop = loop(root.left);
        if (!loop) {
            return false;
        }

        if (val >= root.val) {
            return false;
        }
        val = root.val;

        boolean loop1 = loop(root.right);
        if (!loop1) {
            return false;
        }
        return true;
    }


}
