package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
* */
public class P95 {


    /*
     * 不同的二叉搜索树 II
     * */
    static class Solution {
        /*
         *解题思路，题目要求构造二叉搜索树，而二叉搜索树的中序遍历就是从小到大排列的序列，所以从1到n可以看成中序遍历的结果
         * 而仅根据中序遍历结果是无法还原出原始树的，因为不知道根节点，所以，我们循环依次选用每个节点为根节点，根节点的
         * 左边为左树，右边为右树。但左树右树本身也无法确认根节点，需要递归创建
         * */
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return Collections.emptyList();
            }
            return buildTree(1, n);
        }

        private List<TreeNode> buildTree(int start, int end) {
            List<TreeNode> list = new ArrayList<>();
            //如果start = end 说明只有一个节点
            if (start == end) {
                list.add(new TreeNode(start));
                return list;
            }
            //如果start > end 说明不存在节点，但要在list中放置一个null，否则下面构造左右子树时，返回值为空集合就不会进行遍历了
            if (start > end) {
                list.add(null);
                return list;
            }
            //依次使用每个节点作为根节点
            for (int i = start; i <= end; i++) {
                //左边 右边的值分别构造出树
                List<TreeNode> lefts = buildTree(start, i - 1);
                List<TreeNode> rights = buildTree(i + 1, end);

                //组合左右子树，即为所有情况
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = left;
                        treeNode.right = right;
                        list.add(treeNode);
                    }
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new Solution().generateTrees(10);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
    }

}
