package tree;

import java.util.*;

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * <p>
 * 示例 1：
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * 下面是两个重复的子树：
 * <p>
 * 2
 * /
 * 4
 * 和
 * <p>
 * 4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 */
public class P652 {

    //找到重复的子树
    Set<TreeNode> set = new TreeSet<>(new Comparator<TreeNode>() {
        @Override
        public int compare(TreeNode o1, TreeNode o2) {
            return map.get(o1).compareTo(map.get(o2));
        }
    });

    //筛选重复的子树
    Set<TreeNode> set2 = new TreeSet<>(new Comparator<TreeNode>() {
        @Override
        public int compare(TreeNode o1, TreeNode o2) {
            return map.get(o1).compareTo(map.get(o2));
        }
    });

    //子树:hashcode
    Map<TreeNode, String> map = new HashMap<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        loop2(root);
        return new ArrayList<>(set2);
    }


    //后序遍历每个子树，为每个子树起一个与子树的子树相关code，并存入map
    private void loop2(TreeNode root) {
        if (root == null) {
            return;
        }
        loop2(root.left);
        loop2(root.right);

        String sb = root.val + map.getOrDefault(root.left, "#") + map.getOrDefault(root.right, "*");
        map.put(root, sb);
        boolean add = set.add(root);
        if (!add) {
            set2.add(root);
        }
    }


    public static void main(String[] args) {

        TreeNode t = TreeNode.arrayToTree(new Integer[]{0, 0, 0, 0, null, null, 0, null, null, null, 0});

        List<TreeNode> duplicateSubtrees = new P652().findDuplicateSubtrees(t);
        System.out.println(duplicateSubtrees);
    }

}
