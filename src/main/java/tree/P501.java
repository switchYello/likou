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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P501 {

    static class Solution {

        //提示，此树是二叉搜索树，众数可能有多个
        //方法 按照 中序遍历将二叉搜索树变成从小到大排序的数组
        Set<Integer> set = new HashSet<>();
        int v;
        int maxCount = 0;
        int currentCount = 0;

        public int[] findMode(TreeNode root) {
            doLoop(root);

            int[] result = new int[set.size()];
            int i = 0;
            for (Integer integer : set) {
                result[i++] = integer;
            }
            return result;
        }

        private void doLoop(TreeNode t) {
            if (t == null) {
                return;
            }
            doLoop(t.left);
            //第一次currentCount == 0,设置初始值，以后currentCount就不可能是 0 了
            if (currentCount == 0) {
                v = t.val;
            }
            //更新计数或重置计数
            if (v == t.val) {
                currentCount++;
            } else {
                currentCount = 1;
                v = t.val;
            }
            //计算是否添加到set中，或者刷新set
            if (currentCount == maxCount) {
                set.add(v);
            } else if (currentCount > maxCount) {
                maxCount = currentCount;
                set.clear();
                set.add(v);
            }

            doLoop(t.right);
        }
    }

    public static void main(String[] args) {
        int[] mode = new Solution().findMode(TreeNode.arrayToTree(new Integer[]{1, null, 2}));
        System.out.println(Arrays.toString(mode));

    }


}
