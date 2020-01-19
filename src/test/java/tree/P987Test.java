package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class P987Test {

    @Test
    public void verticalTraversal() {
        {
            TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{3, 9, 20, null, null, 15, 7});
            List<List<Integer>> lists = new P987().verticalTraversal(treeNode);
            Assert.assertEquals(lists.toString(), "[[9], [3, 15], [20], [7]]");
        }

        {
            TreeNode treeNode = TreeNode.arrayToTree(new Integer[]{0, 8, 1, null, null, 3, 2, null, 4, 5, null, null, 7, 6});
            List<List<Integer>> lists = new P987().verticalTraversal(treeNode);
            Assert.assertEquals(lists.toString(), "[[8], [0, 3, 6], [1, 4, 5], [2, 7]]");
        }
    }
}