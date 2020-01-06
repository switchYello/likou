package tree;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序
进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内

**/

public class P501 {

    static class Solution {

        //提示，此树是二叉搜索树，众数可能有多个
        //方法1，可以遍历一遍节点，将所有值存入map内，再返回最大的
        public int[] findMode(TreeNode root) {
            int sum = 1;
            if (root.left != null && root.left.val == root.val) {
                sum++;
            }
            if (root.right != null && root.right.val == root.val) {
                sum++;
            }

            //左子树的众数
            int[] left = findMode(root.left);
            //右子树的众数
            int[] right = findMode(root.right);


        }
    }


}
