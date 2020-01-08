package tree;

import java.util.Deque;
import java.util.LinkedList;

/*给定一个二叉树，确定它是否是一个完全二叉树。

百度百科中对完全二叉树的定义如下：

若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）

 

示例 1：



输入：[1,2,3,4,5,6]
输出：true
解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
示例 2：



输入：[1,2,3,4,5,null,7]
输出：false
解释：值为 7 的结点没有尽可能靠向左侧。
 

提示：

树中将会有 1 到 100 个结点。

链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
* */
public class P958 {

    //二叉树的完全性检验
    static class Solution {

        //是否存在一次null 值
        boolean hasNull = false;

        public boolean isCompleteTree(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    //如果是null则标记
                    if (poll == null) {
                        hasNull = true;
                        continue;
                    }
                    //如果已经存在null，但这里不是null，则不是满的
                    if (hasNull) {
                        return false;
                    }
                    deque.offer(poll.left);
                    deque.offer(poll.right);
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {

        boolean completeTree = new Solution().isCompleteTree(TreeNode.arrayToTree(new Integer[]{1, 2, 5, null, 3, 7, 8}));
        if (completeTree != false) {
            throw new RuntimeException();
        }

        boolean c2 = new Solution().isCompleteTree(TreeNode.arrayToTree(new Integer[]{1, 2, 3, 5}));
        if (c2 != true) {
            throw new RuntimeException();
        }

        boolean c3 = new Solution().isCompleteTree(TreeNode.arrayToTree(new Integer[]{1, 2, 3, null, null, 7, 8}));
        if (c3 != false) {
            throw new RuntimeException();
        }
    }


}
