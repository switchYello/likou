package tree;

import java.util.*;


/*
    给你 root1 和 root2 这两棵二叉搜索树。
            请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.

            示例 1：

            输入：root1 = [2,1,4], root2 = [1,0,3]
            输出：[0,1,1,2,3,4]
            示例 2：

            输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
            输出：[-10,0,0,1,2,5,7,10]
            示例 3：

            输入：root1 = [], root2 = [5,1,7,0,2]
            输出：[0,1,2,5,7]
            示例 4：

            输入：root1 = [0,-10,10], root2 = []
            输出：[-10,0,10]
            示例 5：



            输入：root1 = [1,null,8], root2 = [8,1]
            输出：[1,1,8,8]
             

            提示：

            每棵树最多有 5000 个节点。
            每个节点的值在 [-10^5, 10^5] 之间。

            链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
*/

public class P1305 {

    //两棵二叉搜索树中的所有元素
    /*
     * 遇到二叉搜索树，想到中序遍历来获取从小到大的值
     * 这里创建类TreeIterator，来逐个遍历，但是效率并不高
     *
     * */
    static class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

            List<Integer> list = new ArrayList<>();
            TreeIterator t1 = new TreeIterator(root1);
            TreeIterator t2 = new TreeIterator(root2);
            Integer v1 = null, v2 = null;
            while (v1 != null || v2 != null || t1.hasNext() || t2.hasNext()) {
                if (v1 == null && t1.hasNext()) {
                    v1 = t1.next();
                }
                if (v2 == null && t2.hasNext()) {
                    v2 = t2.next();
                }
                if (v1 == null) {
                    list.add(v2);
                    v2 = null;
                    continue;
                }
                if (v2 == null) {
                    list.add(v1);
                    v1 = null;
                    continue;
                }
                if (v1 > v2) {
                    list.add(v2);
                    v2 = null;
                } else {
                    list.add(v1);
                    v1 = null;
                }
            }
            return list;
        }


        //二叉树的中序遍历器
        static class TreeIterator implements Iterator<Integer> {
            Deque<TreeNode> deque = new LinkedList<>();
            Set<TreeNode> con = new HashSet<>();

            public TreeIterator(TreeNode t) {
                if (t != null) {
                    deque.add(t);
                }
            }

            @Override
            public boolean hasNext() {
                return !deque.isEmpty();
            }

            @Override
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

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.arrayToTree(new Integer[]{0, -10, 10});
        TreeNode t2 = TreeNode.arrayToTree(new Integer[]{5, 1, 7, 0, 2});
        List<Integer> allElements = new Solution().getAllElements(t1, t2);
        System.out.println(allElements);
    }


}
