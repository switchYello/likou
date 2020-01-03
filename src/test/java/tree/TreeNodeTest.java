package tree;

import org.junit.Assert;
import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void treeToArray() {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        System.out.println("原始树:" + t);
        TreeNode treeNode = TreeNode.arrayToTree(t.treeToArray());
        System.out.println("再生树:" + treeNode);
        Assert.assertArrayEquals(t.treeToArray(), treeNode.treeToArray());
    }
}