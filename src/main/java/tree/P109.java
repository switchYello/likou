package tree;

public class P109 {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    static class Solution {

        /*
         * 解法1 同P108，转成数组再按照108的方法解
         * */
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }

            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }

            int[] ints = new int[length];
            int i = 0;
            while (head != null) {
                ints[i] = head.val;
                i++;
                head = head.next;
            }
            return sortedArrayToBST(ints, 0, length - 1);
        }


        private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
            int mid = (start + (end - start + 1) / 2);
            TreeNode node = new TreeNode(nums[mid]);
            if (start != mid) {
                node.left = sortedArrayToBST(nums, start, mid - 1);
            }
            if (mid != end) {
                node.right = sortedArrayToBST(nums, mid + 1, end);
            }
            return node;
        }

        /*
         * 解法2 使用快慢指针解
         * */
        public TreeNode sortedListToBST2(ListNode head) {
            //没有节点或只有一个节点，特殊处理
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }

            //快指针，慢指针，慢指针前指针
            ListNode fast = head,
                    low = head;

            while (true) {
                //因为链上最少两个元素才能执行到这里，不用担心空指针
                ListNode prev = low;
                fast = fast.next;
                fast = fast.next;
                low = low.next;

                //当快指针到头，则慢指针为一半，prev指针为慢指针前一个，断开prev指针和low指针之间的连接
                if (fast == null || fast.next == null) {
                    prev.next = null;
                    break;
                }
            }

            //中间节点作为treeNode
            TreeNode treeNode = new TreeNode(low.val);

            treeNode.left = sortedListToBST2(head);
            if (low.next != null) {
                treeNode.right = sortedListToBST2(low.next);
            }
            return treeNode;
        }

    }

    public static void main(String[] args) {
        int[] ints = {-10, -3, 0, 5, 9};

        ListNode nod = new ListNode(-10);
        ListNode start = nod;
        for (int i = 1; i < ints.length; i++) {
            nod.next = new ListNode(ints[i]);
            nod = nod.next;
        }
        new Solution().sortedListToBST2(start);

    }


}
