package tree;

/*
    你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

示例 1:

输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
示例 2:

输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。

链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
* */
public class P606 {


    static class Solution {
        // 根据二叉树创建字符串
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            String dfs = dfs(t);
            return dfs;
        }

        //先序遍历
        private String dfs(TreeNode t) {
            if (t == null) {
                return "";
            }
            String s = String.valueOf(t.val);
            //左右都是null
            if (t.left == null && t.right == null) {
                return s;
            }
            //如果仅有左树，则忽略右树
            if (t.right == null) {
                return s + "(" + dfs(t.left) + ")";
            }

            //如果有右树,则左树是否为空都不能忽略
            return s + "(" + dfs(t.left) + ")" + "(" + dfs(t.right) + ")";
        }

    }

    public static void main(String[] args) {
        String tree2str = new Solution().tree2str(TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4}));
        System.out.println(tree2str);

    }


}
