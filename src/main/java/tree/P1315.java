package tree;

/**
 * 祖父节点值为偶数的节点和
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 */
public class P1315 {


    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.val % 2 == 0) {
            sum += getGreatSon(root);
        }
        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }

    //获取孙子节点的值之和
    private int getGreatSon(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            TreeNode left = root.left;
            if (left.left != null) {
                sum += left.left.val;
            }
            if (left.right != null) {
                sum += left.right.val;
            }
        }
        if (root.right != null) {
            TreeNode right = root.right;
            if (right.left != null) {
                sum += right.left.val;
            }
            if (right.right != null) {
                sum += right.right.val;
            }
        }
        return sum;
    }


}
