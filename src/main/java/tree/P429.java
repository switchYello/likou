package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *  
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 */

public class P429 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int size = queue.size();
            //每次取一层数据，放入queue，将值放入sub
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                sub.add(poll.val);
                if (poll.children != null) {
                    for (Node child : poll.children) {
                        if (child != null) {
                            queue.add(child);
                        }
                    }
                }
            }
            list.add(sub);
        }
        return list;
    }


}
