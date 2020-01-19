package tree;

import tool.Check;

/**
 * 从叶结点开始的最小字符串
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 * <p>
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * <p>
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,1,null,1,0,null,0]
 * 输出："abc"
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树的结点数介于 1 和 8500 之间。
 * 树中的每个结点都有一个介于 0 和 25 之间的值。
 * <p>
 * 链接：https://leetcode-cn.com/problems/smallest-string-starting-from-leaf
 */
public class P988 {

    String min = "{";

    /*
     * 这里直接进行从根节点递归聚合从整条路径
     * 每次到叶子结点后，和min进行比较，保存最小的
     * */
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        loop(root, "");
        return min;
    }


    //
    private void loop(TreeNode root, String value) {
        if (root == null) {
            return;
        }
        String current = parseChar(root.val) + value;
        //每次到叶子结点就和最小值比较
        if (root.left == null && root.right == null) {
            min = min.compareTo(current) < 0 ? min : current;
            return;
        }
        loop(root.left, current);
        loop(root.right, current);
    }

    //0-25 转成 ‘a’-'z'
    private char parseChar(int value) {
        return (char) (value + 'a');
    }


    public static void main(String[] args) {
        {
            TreeNode root = TreeNode.arrayToTree(new Integer[]{0, 1, 2, 3, 4, 3, 4});
            String s = new P988().smallestFromLeaf(root);
            Check.checkTrue("dba".equals(s));
        }
        {
            TreeNode root = TreeNode.arrayToTree(new Integer[]{25, 1, 3, 1, 3, 0, 2});
            String s = new P988().smallestFromLeaf(root);
            Check.checkTrue("adz".equals(s));
        }
        {
            TreeNode root = TreeNode.arrayToTree(new Integer[]{2, 2, 1, null, 1, 0, null, 0});
            String s = new P988().smallestFromLeaf(root);
            Check.checkTrue("abc".equals(s));
        }

        {
            TreeNode root = TreeNode.arrayToTree(new Integer[]{4, 0, 1, 1});
            String s = new P988().smallestFromLeaf(root);
            Check.checkTrue("bae".equals(s));
        }

        {
            TreeNode root = TreeNode.arrayToTree(new Integer[]{25, 1, null, 0, 0, 1, null, null, null, 0});
            String s = new P988().smallestFromLeaf(root);
            Check.checkTrue("ababz".equals(s));
        }

    }


}
