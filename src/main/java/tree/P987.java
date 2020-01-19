package tree;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * 二叉树的垂序遍历
 * 给定二叉树，按垂序遍历返回其结点值。
 * <p>
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 * <p>
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 * <p>
 * 如果两个结点位置相同，则首先报告的结点值较小。
 * <p>
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
 * 然后，值为 9 的结点出现在 (-1, -1)；
 * 值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
 * 值为 20 的结点出现在 (1, -1)；
 * 值为 7 的结点出现在 (2, -2)。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
 * 然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。
 *  
 * <p>
 * 提示：
 * <p>
 * 树的结点数介于 1 和 1000 之间。
 * 每个结点值介于 0 和 1000 之间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 */
public class P987 {


    static Comparator<? super Node> c = Comparator.comparingInt((ToIntFunction<Node>) o -> o.y).thenComparingInt(value -> value.value);
    Map<Integer, List<Node>> map = new TreeMap<>();

    /*
     *为每个节点起起一个x，y坐标，y相同的则是同一列，x相同的则是同一行
     * */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        loop(0, 0, root);
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Node>> es : map.entrySet()) {
            //输出时的排序是按照y坐标排序,如果y坐标相等，按照值大小排序
            es.getValue().sort(c);
            list.add(es.getValue().stream().map(s -> s.value).collect(Collectors.toList()));
        }
        return list;
    }

    /* 保存每个节点的x坐标和节点的值
     * 因为是按照列打印,使用map的键做为x坐标
     * */
    private void loop(int x, int y, TreeNode root) {
        if (root == null) {
            return;
        }

        List<Node> list = map.computeIfAbsent(x, k -> new ArrayList<>());
        list.add(new Node(root.val, x, y));
        loop(x - 1, y + 1, root.left);
        loop(x + 1, y + 1, root.right);
    }

    static class Node {
        int value;
        int x;
        int y;

        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

}
