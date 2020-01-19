package tree;

import org.junit.Test;
import tool.Check;

public class P979Test {

    @Test
    public void distributeCoins() {

        Check.checkTrue(new P979().distributeCoins(TreeNode.arrayToTree(new Integer[]{3, 0, 0})) == 2);
        Check.checkTrue(new P979().distributeCoins(TreeNode.arrayToTree(new Integer[]{0, 3, 0})) == 3);
        Check.checkTrue(new P979().distributeCoins(TreeNode.arrayToTree(new Integer[]{1, 0, 2})) == 2);
        Check.checkTrue(new P979().distributeCoins(TreeNode.arrayToTree(new Integer[]{1, 0, 0, null, 3})) == 4);
        
    }
}