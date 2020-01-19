package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 */
public class P449 {

    /**
     * @see P1008 根据先序遍历还原出二叉搜索树
     * 这题也是二叉搜索树，可以参考下。我这里用了层次遍历
     */
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            Integer[] integers = treeToArray(root);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : integers) {
                sb.append(integer).append(",");
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] split = data.split(",");
            Integer[] integers = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                if ("null".equals(split[i])) {
                    continue;
                }
                integers[i] = Integer.valueOf(split[i]);
            }
            return arrayToTree(integers);
        }


        //按照层次遍历，将树转成数组
        public Integer[] treeToArray(TreeNode root) {
            Deque<Integer> ans = new LinkedList<>();

            //先按照层次遍历将节点写入ans中，若节点为null，则写入null
            Deque<TreeNode> list = new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()) {
                TreeNode poll = list.poll();
                if (poll == null) {
                    ans.add(null);
                } else {
                    ans.add(poll.val);
                    list.offer(poll.left);
                    list.offer(poll.right);
                }
            }

            //倒序删除，知道遇见一个非null的元素为止
            while (!ans.isEmpty() && ans.peekLast() == null) {
                ans.removeLast();
            }
            return ans.toArray(new Integer[0]);
        }

        //将上面按照层次遍历得到的树数组还原成树
        public static TreeNode arrayToTree(Integer[] array) {
            int i = 0;
            TreeNode root = new TreeNode(array[i++]);
            Deque<TreeNode> list = new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()) {
                TreeNode t = list.poll();
                if (i < array.length && array[i] != null) {
                    TreeNode left = new TreeNode(array[i]);
                    t.left = left;
                    list.offer(left);
                }

                i++;
                if (i < array.length && array[i] != null) {
                    TreeNode right = new TreeNode(array[i]);
                    t.right = right;
                    list.offer(right);
                }
                i++;
            }
            return root;
        }


    }


}
