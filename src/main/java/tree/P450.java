package tree;

/**
 * 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 * <p>
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 */
public class P450 {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //若当前节点大于key，则使用左树重新调用
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        //若当前节点小于key，则使用右树重新调用
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        //若删除的节点是根节点，但右边是null，则直接返回左边子树
        if (root.right == null) {
            return root.left;
        }
        if (root.left == null) {
            return root.right;
        }
        //删除根节点，则根节点变成右树的最左边节点
        root.val = getLeftVal(root.right).val;
        //再从根节点中删除最左边节点
        root.right = deleteNode(root.right, root.val);
        return root;
    }

    /*
     * 获取先序遍历的第一个节点
     * */
    private TreeNode getLeftVal(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    public static void main(String[] args) {
        {
            TreeNode t = TreeNode.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
            TreeNode treeNode = new P450().deleteNode(t, 3);
            System.out.println(treeNode);
        }
        {
            TreeNode t = TreeNode.arrayToTree(new Integer[]{3, 1, 4, null, 2});
            TreeNode treeNode = new P450().deleteNode(t, 3);
            System.out.println(treeNode);
        }
    }

}
