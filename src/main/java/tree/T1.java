package tree;
/*
 * 二叉树的遍历
 * 七种方式
 *
 * */

import java.util.*;

public class T1 {

    //1.递归先序遍历
    private static void loop1(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + "  ");
        loop1(treeNode.left);
        loop1(treeNode.right);
    }

    //2.递归中序遍历
    private static void loop2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        loop2(treeNode.left);
        System.out.print(treeNode.val + "  ");
        loop2(treeNode.right);
    }

    //3.递归后序遍历
    private static void loop3(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        loop3(treeNode.left);
        loop3(treeNode.right);
        System.out.print(treeNode.val + "  ");
    }

    //4.非递归层次遍历
    private static void loop4(TreeNode treeNode) {
        Queue<TreeNode> list = new LinkedList<>();
        list.add(treeNode);

        while (true) {
            TreeNode t = list.poll();//弹出头，为空则返回null
            //表示queue内没元素了
            if (t == null) {
                return;
            }
            System.out.print(t.val + "  ");
            if (t.left != null) {
                list.offer(t.left);
            }
            if (t.right != null) {
                list.offer(t.right);
            }
        }
    }

    //5.非递归先序遍历
    private static void loop5(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        deque.add(treeNode);
        while (!deque.isEmpty()) {
            TreeNode t = deque.poll();
            //如果第一位是叶子节点或已经操作过的节点，则打印
            if ((t.left == null && t.right == null) || list.remove(t)) {
                System.out.print(t.val + "  ");
                continue;
            }
            //否则按照 [根 左 右] 的顺序再次存入入栈，栈先入后取
            if (t.right != null) {
                deque.push(t.right);
            }
            if (t.left != null) {
                deque.push(t.left);
            }
            deque.push(t);
            //将此节点t 标记为已处理过
            list.add(t);
        }
    }

    //6.非递归中序遍历
    private static void loop6(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        deque.add(treeNode);
        while (!deque.isEmpty()) {
            TreeNode t = deque.poll();
            //如果第一位是叶子节点或已经操作过的节点，则打印
            if ((t.left == null && t.right == null) || list.remove(t)) {
                System.out.print(t.val + "  ");
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
    }

    //7.非递归中序遍历
    private static void loop7(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        deque.add(treeNode);
        while (!deque.isEmpty()) {
            TreeNode t = deque.poll();
            //如果第一位是叶子节点或已经操作过的节点，则打印
            if ((t.left == null && t.right == null) || list.remove(t)) {
                System.out.print(t.val + "  ");
                continue;
            }
            //否则按照 [左 右 根] 的顺序再次存入队列，且标记root为已操作过节点
            deque.push(t);

            if (t.right != null) {
                deque.push(t.right);
            }
            if (t.left != null) {
                deque.push(t.left);
            }
            list.add(t);
        }
    }


    /*
             10
          /    \
         5      -3
       / \       \
      3   2      11
     / \   \
    3  -2   1
    * */
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        loop1(root);
    }


}
