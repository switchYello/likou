package tree;

import org.junit.Assert;
import org.junit.Test;

public class P684Test {

    @Test
    public void findRedundantConnection() {
        {
            int[][] it = new int[][]{{1, 2}, {1, 3}, {2, 3}};
            int[] redundantConnection = new P684().findRedundantConnection(it);
            Assert.assertArrayEquals(redundantConnection, new int[]{2, 3});
        }
        {
            int[][] it = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
            int[] redundantConnection = new P684().findRedundantConnection(it);
            Assert.assertArrayEquals(redundantConnection, new int[]{1, 4});
        }

    }
}