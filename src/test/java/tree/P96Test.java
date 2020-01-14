package tree;

import org.junit.Test;
import tool.Check;

import static org.junit.Assert.*;

public class P96Test {

    @Test
    public void numTrees() {
        Check.checkTrue(new P96().numTrees(0) == 0);
        Check.checkTrue(new P96().numTrees(1) == 1);
        Check.checkTrue(new P96().numTrees(2) == 2);
        Check.checkTrue(new P96().numTrees(3) == 5);
    }
}