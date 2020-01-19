package tree;

import tool.Check;

/**
 * 翻转等价二叉树
 * <p>
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * <p>
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * <p>
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * 输出：true
 * 解释：We flipped at nodes with values 1, 3, and 5.
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 100 个节点。
 * 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数。
 *  
 * <p>
 * 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
 */
public class P951 {


    //递归比较，需要注意的是，可以左边和左边相同右边右边相同，也可以左边右边相同右边左边相同
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (!nodeSame(root1, root2)) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

    //比较两个节点是否相同
    private boolean nodeSame(TreeNode r1, TreeNode r2) {

        if (r1 == null) {
            return false;
        }
        if (r2 == null) {
            return false;
        }
        return r1.val == r2.val;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8});
        TreeNode t2 = TreeNode.arrayToTree(new Integer[]{1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7});
        Check.checkTrue(new P951().flipEquiv(t1, t2));

    }


}
