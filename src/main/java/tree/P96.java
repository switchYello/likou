package tree;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 */
public class P96 {


    /*
     * 解题思路是，二叉搜索树的中序遍历是从小到大的序列，这样依次使用每个节点作为根节点，左右两边分别是左右子树
     * 这样可以把n的问题化解为 [1- i-1], [i+1 - n]两个子区间来解，同时加上缓存.
     * */
    public int numTrees(int n) {

        if (n <= 0) {
            return 0;
        }
        //这是从底向上的备忘录方法
        int[] m = new int[n + 1];
        m[0] = 1;

        //i 表示有几个节点，想要求出n个节点的值，先分别求出1，2，3，4，5 ... n-1的值
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                int left = m[j];
                int right = m[i - 1 - j];
                sum += right * left;
            }
            m[i] = sum;
        }

        return m[n];

    }

}
