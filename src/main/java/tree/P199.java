package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 */

public class P199 {

    /*
     * 返回右视图
     * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                //将第一个存入list
                if (i == 0) {
                    list.add(poll.val);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<Integer> rightSideView = new P199().rightSideView(TreeNode.arrayToTree(new Integer[]{1, 2, 3, null, 5, null, 4}));
        System.out.println(rightSideView);

    }

}
