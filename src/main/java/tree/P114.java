package tree;

/*
* 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
* */
public class P114 {


    //将二叉树‘原地地’展开为链表
    //题意是按照先序遍历的顺序，将节点都串在右子树上
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenHelp(root);
    }

    TreeNode first;

    //这里采用先序遍历的反向遍历【右 左 根】 将节点倒序的串在first这个节点上
    private void flattenHelp(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenHelp(root.right);
        flattenHelp(root.left);

        root.right = first;
        root.left = null;
        first = root;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.arrayToTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new P114().flatten(t1);
        System.out.println(t1);

    }


}
