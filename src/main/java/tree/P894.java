package tree;


import java.util.ArrayList;
import java.util.List;

/*
* 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

答案中每个树的每个结点都必须有 node.val=0。

你可以按任何顺序返回树的最终列表。

 

示例：

输入：7
输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
解释：

 

提示：

1 <= N <= 20

链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
* */
public class P894 {

    //和p95有点像，可以参考下
    static class Solution {

        // 所有可能的满二叉树
        public List<TreeNode> allPossibleFBT(int N) {
            return buildTree(N);
        }


        private List<TreeNode> buildTree(int N) {
            List<TreeNode> list = new ArrayList<>();
            //偶数情况，返回空集合
            if (N % 2 == 0) {
                return list;
            }
            //单节点
            if (N == 1) {
                list.add(new TreeNode(0));
                return list;
            }
            //能走到这里最少存在3个节点
            //按照步长为2，划分左右子树
            for (int i = 1; i < N; i += 2) {
                List<TreeNode> lefts = buildTree(i);
                List<TreeNode> rights = buildTree(N - 1 - i);
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode t = new TreeNode(0);
                        t.left = left;
                        t.right = right;
                        list.add(t);
                    }
                }
            }
            return list;
        }
    }


}
