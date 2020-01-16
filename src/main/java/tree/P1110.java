package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 */
public class P1110 {

    List<TreeNode> result = new ArrayList<>();
    List<Integer> delete = new ArrayList<>();

    /*
     * todo
     * 这题没想出来，看答案的
     * */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            delete.add(i);
        }
        TreeNode loop = loop(root);
        if (loop != null) {
            result.add(loop);
        }
        return result;
    }

    public TreeNode loop(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = loop(root.left);
        root.right = loop(root.right);

        if (delete.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        {
            TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
            int[] deletes = {3, 5};
            List<TreeNode> treeNodes = new P1110().delNodes(treeNode, deletes);
            System.out.println(treeNodes);
        }
    }

}
