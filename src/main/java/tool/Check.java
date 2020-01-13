package tool;

import java.util.Arrays;

public class Check {

    public static void checkTrue(boolean p) {
        if (!p) {
            throw new RuntimeException();
        }
    }

    public static void checkFalse(boolean p) {
        if (p) {
            throw new RuntimeException();
        }
    }

    public static void checkItemEqual(int[] a, int[] b) {
        if (a == null && b == null) {
            return;
        }
        if (a == null) {
            throw new RuntimeException("a is null");
        }
        if (b == null) {
            throw new RuntimeException(" b is null");
        }
        if (a.length != b.length) {
            throw new RuntimeException("a.length != b.length a:" + Arrays.toString(a) + ",b:" + Arrays.toString(b));
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                throw new RuntimeException("not equal a:" + Arrays.toString(a) + ",b:" + Arrays.toString(b));
            }
        }
    }

}
