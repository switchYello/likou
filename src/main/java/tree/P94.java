package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
* 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
* */
public class P94 {

    /*
    * 二叉树的非递归中序遍历，使用一个辅助list，理解起来很简单
    * */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode t = deque.poll();
            //如果第一位是叶子节点或已经操作过的节点，则打印
            if ((t.left == null && t.right == null) || list.remove(t)) {
                result.add(t.val);
                continue;
            }
            //否则按照 [左 根 右] 的方式再次存入队列
            if (t.right != null) {
                deque.push(t.right);
            }
            deque.push(t);
            if (t.left != null) {
                deque.push(t.left);
            }
            //标记为已处理
            list.add(t);
        }
        return result;
    }


}
