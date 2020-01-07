package tree;

/*
    给定一个二叉树，计算整个树的坡度。
    一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
    整个树的坡度就是其所有节点的坡度之和。
    示例:

    输入:
             1
           /   \
          2     3
    输出: 1
    解释:
    结点的坡度 2 : 0
    结点的坡度 3 : 0
    结点的坡度 1 : |2-3| = 1
    树的坡度 : 0 + 0 + 1 = 1
    注意:

    任何子树的结点的和不会超过32位整数的范围。
    坡度的值不会超过32位整数的范围。

**/

public class P563 {

    /*
    树的坡度 = 所有节点坡度之和
    节点坡度 = abs(左子树节点值的和 - 右子树节点值的和)
    空节点坡度 = 0
    * */

    static class Solution {

        //存储坡度和
        int sum = 0;

        public int findTilt(TreeNode root) {
            if (root == null) {
                return 0;
            }
            setVal(root);
            setTilt(root);
            return sum;
        }

        //后序遍历树，从底向上遍历将每个节点的值叠加上左右节点的值
        private int setVal(TreeNode t) {
            if (t == null) {
                return 0;
            }

            t.val += setVal(t.left) + setVal(t.right);
            return t.val;
        }

        //使用先序遍历，从上到下，计算出每个节点的坡度叠加到sum中
        //节点的坡度 = abs(left.val,right.val),因为上一步已经将节点的值设置为整棵树的值之和
        private void setTilt(TreeNode t) {
            if (t == null) {
                return;
            }
            int left = 0, right = 0;
            if (t.left != null) {
                left = t.left.val;
            }
            if (t.right != null) {
                right = t.right.val;
            }
            sum += Math.abs(left - right);
            setTilt(t.left);
            setTilt(t.right);
        }


        //这是官方答案
        //做法也是从低向上遍历，但是他在遍历时顺便将坡度求出了，累加到tilt上
        static class Solution2 {
            int tilt = 0;

            public int findTilt(TreeNode root) {
                traverse(root);
                return tilt;
            }

            public int traverse(TreeNode root) {
                if (root == null)
                    return 0;
                int left = traverse(root.left);
                int right = traverse(root.right);
                tilt += Math.abs(left - right);
                return left + right + root.val;
            }
        }


    }

    public static void main(String[] args) {

        int tilt = new Solution().findTilt(TreeNode.arrayToTree(new Integer[]{1, 2, 3, 4, null, 5}));
        System.out.println(tilt);

    }


}
