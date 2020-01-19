package tree;

import tool.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * 出现次数最多的子树元素和
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * <p>
 *  
 * <p>
 * 示例 1
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * <p>
 * 示例 2
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * <p>
 *  
 * <p>
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示
 * <p>
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 */
public class P508 {

    /*
     * 解法就是求出二叉树每个子树的所有节点和，都存入map里
     * 然后返回出现次数最多那几个
     * */
    public int[] findFrequentTreeSum(TreeNode root) {
        setTreeValue(root);

        int[] keys = new int[map.size()];
        int index = 0;
        int max = 0;
        //遍历map中的键值对，找出最大的若干个
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            if (value > max) {
                index = 0;
                keys[index++] = key;
                max = value;
            } else if (value == max) {
                keys[index++] = key;
            }
        }

        int[] ints = new int[index];
        System.arraycopy(keys, 0, ints, 0, index);
        return ints;

    }

    //存储出现的【值，次数】的对应关系
    Map<Integer, Integer> map = new HashMap<>();

    //返回值是该树的所有节点和
    //顺便将值统计到map中
    private int setTreeValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = setTreeValue(root.left);
        int right = setTreeValue(root.right);
        addValue(left + right + root.val);
        return left + right + root.val;
    }

    //更新值次数
    private void addValue(int value) {
        map.put(value, 1 + map.getOrDefault(value, 0));
    }

    public static void main(String[] args) {

        {
            int[] frequentTreeSum = new P508().findFrequentTreeSum(TreeNode.arrayToTree(new Integer[]{5, 2, -3}));
            Check.checkItemEqual(frequentTreeSum, new int[]{2, -3, 4});
        }

        {
            int[] frequentTreeSum = new P508().findFrequentTreeSum(TreeNode.arrayToTree(new Integer[]{5, 2, -5}));
            Check.checkItemEqual(frequentTreeSum, new int[]{2});
        }


    }

}
