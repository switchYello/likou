package tree;

import java.util.HashSet;
import java.util.Set;

/*
    给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

案例 1:

输入:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

输出: True
 

案例 2:

输入:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

输出: False

链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
* */
public class P653 {


    static
    class Solution {
        //两数之和 IV - 输入 BST
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            return dfs(root, k);
        }

        //存储希望得到的值，如果得到这里面的值，就能配对成功
        Set<Integer> want = new HashSet<>();

        private boolean dfs(TreeNode t, int k) {
            if (t == null) {
                return false;
            }
            if (want.contains(t.val)) {
                return true;
            }
            want.add(k - t.val);

            return dfs(t.left, k) || dfs(t.right, k);
        }

    }

}
