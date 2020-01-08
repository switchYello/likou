package tree;

import java.util.HashSet;
import java.util.Set;

/*
* 给出一个满足下述规则的二叉树：

root.val == 0
如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。

请你先还原二叉树，然后实现 FindElements 类：

FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 

示例 1：



输入：
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
输出：
[null,false,true]
解释：
FindElements findElements = new FindElements([-1,null,-1]);
findElements.find(1); // return False
findElements.find(2); // return True
示例 2：



输入：
["FindElements","find","find","find"]
[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
输出：
[null,true,true,false]
解释：
FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
findElements.find(1); // return True
findElements.find(3); // return True
findElements.find(5); // return False
示例 3：



输入：
["FindElements","find","find","find","find"]
[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
输出：
[null,true,false,false,true]
解释：
FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
findElements.find(2); // return True
findElements.find(3); // return False
findElements.find(4); // return False
findElements.find(5); // return True
 

提示：

TreeNode.val == -1
二叉树的高度不超过 20
节点的总数在 [1, 10^4] 之间
调用 find() 的总次数在 [1, 10^4] 之间
0 <= target <= 10^6

链接：https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree
*
* */
public class P1261 {

    //在受污染的二叉树中查找元素
    static class FindElements {

        TreeNode root;
        Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            this.root = root;
            hy(root);
        }

        //按照规则还原出被污染的树，并顺便将值存入set内
        private void hy(TreeNode root) {
            set.add(root.val);
            if (root.left != null) {
                root.left.val = root.val * 2 + 1;
                hy(root.left);
            }
            if (root.right != null) {
                root.right.val = root.val * 2 + 2;
                hy(root.right);
            }
        }

        //方法1：使用set存储所有节点的
        public boolean find(int target) {
            return set.contains(target);
        }

        //方法2：根据规则反向查
        public boolean find2(int target) {
            return findHelp(target) != null;
        }

        private TreeNode findHelp(int target) {
            if (target < 0) {
                return null;
            }
            if (target == 0) {
                return root;
            }
            if (target % 2 == 0) {
                TreeNode help = findHelp((target - 2) / 2);
                return help == null ? null : help.right;
            } else {
                TreeNode help = findHelp((target - 1) / 2);
                return help == null ? null : help.left;
            }
        }

    }


}
