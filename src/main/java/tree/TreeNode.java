package tree;

import java.util.*;

/*
 * 二叉树
 * */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    //按照层次遍历，将树转成数组
    public Integer[] treeToArray() {
        Deque<Integer> ans = new LinkedList<>();

        //先按照层次遍历将节点写入ans中，若节点为null，则写入null
        Deque<TreeNode> list = new LinkedList<>();
        list.offer(this);
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

    @Override
    public String toString() {
        return Arrays.toString(treeToArray());
    }


}
