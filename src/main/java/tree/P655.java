package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * /
 * 2
 * 输出:
 * [["", "1", ""],
 * ["2", "", ""]]
 * 示例 2:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * 示例 3:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 * <p>
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 */
public class P655 {

    /*
     * todo 没搞出来，看答案的
     * */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> empty = new ArrayList<>();

        if (root == null) {
            return empty;
        }
        //获取二维数组的x长度，为树的深度
        int x = getDepth(root);
        //获取二维数组的y，为 pow(2,x)-1
        int y = (1 << x) - 1;

        //递归二分法填充二维数组
        String[][] result = new String[x][y];
        fill(result, 0, 0, y - 1, root);

        //数组转成list返回
        for (String[] ss : result) {
            List<String> list = new ArrayList<>();
            for (String s : ss) {
                list.add(s == null ? "" : s);
            }
            empty.add(list);
        }
        return empty;
    }

    /*
     * @param result 空二维数组
     * @param x      深度x坐标
     * @param start  均为闭区间
     * @param end
     * @param root   树
     */
    void fill(String[][] result, int x, int start, int end, TreeNode root) {
        if (root == null) {
            return;
        }
        //求出中间坐标
        int mid = (end - start) / 2 + start;
        result[x][mid] = String.valueOf(root.val);
        //填充左树
        fill(result, x + 1, start, mid - 1, root.left);
        //填充右树
        fill(result, x + 1, mid + 1, end, root.right);
    }


    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        P655 p = new P655();
        TreeNode t = TreeNode.arrayToTree(new Integer[]{1, 2, 3, null, 4});
        List<List<String>> lists = p.printTree(t);
        System.out.println();
        System.out.println(lists);

    }


}
