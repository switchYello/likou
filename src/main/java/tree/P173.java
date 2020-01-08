package tree;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。


示例：

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false
 

提示：

next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数

链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
* */
public class P173 {

    //二叉搜索树迭代器
    //解法就是使用中序遍历，每次返回一个
    static class BSTIterator {
        Deque<TreeNode> deque = new LinkedList<>();
        Set<TreeNode> con = new HashSet<>();

        public BSTIterator(TreeNode t) {
            if (t != null) {
                deque.add(t);
            }
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }

        public Integer next() {
            TreeNode poll = deque.poll();
            if ((poll.left == null && poll.right == null) || con.remove(poll)) {
                return poll.val;
            }
            if (poll.right != null) {
                deque.push(poll.right);
            }
            deque.push(poll);
            con.add(poll);
            if (poll.left != null) {
                deque.push(poll.left);
            }
            return next();
        }


    }


}
