package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 完全二叉树插入器
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 TreeNode 的父结点的值；
 * CBTInserter.get_root() 将返回树的头结点。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 *  
 * <p>
 * 提示：
 * <p>
 * 最初给定的树是完全二叉树，且包含 1 到 1000 个结点。
 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
 * 给定结点或插入结点的每个值都在 0 到 5000 之间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/complete-binary-tree-inserter
 */
public class P919 {
    /*
     * 参考答案后发现，list里面的值，在index之前的节点都没有使用到，是不用保存的
     *
     * */


    //按照完全二叉树的规则插入节点
    static class CBTInserter {
        //从从上到下，左到右的顺序保存节点
        private List<TreeNode> list = new ArrayList<>();
        //当前未满节点索引
        private int index = -1;
        //是否找到当前未满节点
        private boolean find = false;

        //层次遍历
        public CBTInserter(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    list.add(poll);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                    //找到应该添加元素的节点
                    if (!find) {
                        index++;
                        //如果一个节点缺少左节点或右节点，该节点是未满的
                        if (poll.left == null || poll.right == null) {
                            find = true;
                        }
                    }
                }
            }
        }


        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            list.add(node);

            //添加到未满节点左边或右边，如果添加到右边，未满节点索引后移一位
            TreeNode treeNode = list.get(index);
            if (treeNode.left == null) {
                treeNode.left = node;
            } else {
                treeNode.right = node;
                index++;
            }
            return treeNode.val;
        }


        public TreeNode get_root() {
            return list.get(0);
        }

    }


    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{1, 2, 3});
        CBTInserter cbtInserter = new CBTInserter(treeNode);

        for (int i = 4; i < 20; i++) {
            System.out.println(cbtInserter.insert(i));
            System.out.println(cbtInserter.get_root());
            System.out.println();
        }

    }


}
