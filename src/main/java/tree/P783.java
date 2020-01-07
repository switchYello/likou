package tree;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

示例：

输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树结点对象(TreeNode object)，而不是数组。

给定的树 [4,2,6,1,3,null,null] 可表示为下图:

          4
        /   \
      2      6
     / \
    1   3

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
注意：

二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。

链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
* */
public class P783 {

    //二叉搜索树结点最小距离


    static
    class Solution {


        public int minDiffInBST(TreeNode root) {
            //中序遍历二叉搜索树，得到的结果为从小到大排序的序列
            List<TreeNode> list = new ArrayList<>();
            allNode(root, list);

            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, list.get(i).val - list.get(i - 1).val);
                if (min == 0) {
                    return 0;
                }
            }
            return min;

        }

        private void allNode(TreeNode root, List<TreeNode> all) {
            if (root == null) {
                return;
            }
            allNode(root.left, all);
            all.add(root);
            allNode(root.right, all);
        }

    }

    public static void main(String[] args) {
        int i = new Solution().minDiffInBST(TreeNode.arrayToTree(new Integer[]{4, 2, 6, 1, 3, null, null}));
        System.out.println(i);
    }


}
