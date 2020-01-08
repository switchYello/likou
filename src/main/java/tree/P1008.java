package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。

(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）

 

示例：

输入：[8,5,1,7,10,12]
输出：[8,5,10,1,7,null,12]

 

提示：

1 <= preorder.length <= 100
先序 preorder 中的值是不同的。

链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
* */
public class P1008 {

    //先序遍历构造二叉树
    static class Solution {
        /*
         * 题目只给先序遍历是无法构造二叉树的，但隐藏条件是二叉搜索树，则中序遍历的结果为从小到大的排序
         * 再根据这两个序列就能还原出树了就能还原出树了
         * 1.写法1是获得中序遍历，然后还原
         * 2.写法2是直接递归
         *
         * */
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            int[] inorder = new int[preorder.length];
            System.arraycopy(preorder, 0, inorder, 0, preorder.length);
            Arrays.sort(inorder);

            Map<Integer, Integer> idMap = new HashMap<>();
            int inOrderIndex = 0;
            for (int inorderItem : inorder) {
                idMap.put(inorderItem, inOrderIndex++);
            }

            return buildTree(preorder, idMap, 0, preorder.length - 1);
        }

        int preindex = 0;

        private TreeNode buildTree(int[] preorder, Map<Integer, Integer> idMap, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preindex++]);
            if (start == end) {
                return root;
            }
            Integer inorderIndex = idMap.get(root.val);
            root.left = buildTree(preorder, idMap, start, inorderIndex - 1);
            root.right = buildTree(preorder, idMap, inorderIndex + 1, end);
            return root;
        }


        /*
         * 第二种写法，因为是是搜索树，所以左边要比右边小
         * */
        public TreeNode bstFromPreorder2(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            return buildHapper(preorder, 0, preorder.length - 1);
        }

        //start end 都是闭区间
        //使用递归，第一个节点一定是根节点，然后继续循环preorder，遇到的比preorder[start] 小的属于左树，大的属于右树，然后递归左右子树
        private TreeNode buildHapper(int[] preorder, int start, int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return new TreeNode(preorder[start]);
            }
            TreeNode treeNode = new TreeNode(preorder[start]);

            //最后一个比当前值小的索引
            int lastLtIndex = start;
            for (int i = start + 1; i <= end; i++) {
                if (preorder[i] > preorder[start]) {
                    break;
                }
                lastLtIndex = i;
            }

            treeNode.left = buildHapper(preorder, start + 1, lastLtIndex);
            treeNode.right = buildHapper(preorder, lastLtIndex + 1, end);

            return treeNode;
        }


    }


}
