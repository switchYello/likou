package tree;

import java.util.*;

/*
    给定一个二叉树，返回所有从根节点到叶子节点的路径。

    说明: 叶子节点是指没有子节点的节点。

    示例:

    输入:

       1
     /   \
    2     3
     \
      5

    输出: ["1->2->5", "1->3"]

    解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

* */
public class P257 {


    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            //叶子节点，返回当前节点的值
            if (root.left == null && root.right == null) {
                return Collections.singletonList(String.valueOf(root.val));
            }
            List<String> left = binaryTreePaths(root.left);
            List<String> right = binaryTreePaths(root.right);

            List<String> result = new ArrayList<>();
            for (String s : left) {
                result.add(root.val + "->" + s);
            }
            for (String s : right) {
                result.add(root.val + "->" + s);
            }
            return result;
        }


        public List<String> binaryTreePaths2(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            Deque<Pair<TreeNode, StringBuilder>> deque = new LinkedList<>();
            deque.add(new Pair<>(root, new StringBuilder(root.val + "")));
            while (!deque.isEmpty()) {
                Pair<TreeNode, StringBuilder> poll = deque.poll();
                TreeNode key = poll.getKey();
                if (key.left == null && key.right == null) {
                    result.add(poll.getValue().toString());
                    continue;
                }
                if (key.left != null) {
                    deque.offer(new Pair<>(key.left, new StringBuilder(poll.getValue()).append("->").append(key.left.val)));
                }
                if (key.right != null) {
                    deque.offer(new Pair<>(key.right, poll.getValue().append("->").append(key.right.val)));
                }
            }
            return result;

        }

        //这是题解的递归写法
        public List<String> binaryTreePaths3(TreeNode root) {
            LinkedList<String> paths = new LinkedList<>();
            construct_paths(root, "", paths);
            return paths;
        }

        //注意此函数内的path，字符串是不可变对象，进行操作后会生成新对象
        void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
            if (root != null) {
                path += Integer.toString(root.val);
                if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
                    paths.add(path);  // 把路径加入到答案中
                else {
                    path += "->";  // 当前节点不是叶子节点，继续递归遍历
                    construct_paths(root.left, path, paths);
                    construct_paths(root.right, path, paths);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.arrayToTree(new Integer[]{1, 2, 3, null, 5});
        new Solution().binaryTreePaths3(t);


    }


}
