package tree;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class P103 {


    List<List<Integer>> lists = new ArrayList<>();

    //层次遍历的变种，找一个变量来表示当前行是否需要逆序
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return lists;
        }
        boolean rever = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            if (!list.isEmpty()) {
                lists.add(list);
                if (rever) {
                    Collections.reverse(list);
                }
                rever = !rever;
            }
        }
        return lists;
    }


}
