package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * <p>
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= label <= 10^6
 * <p>
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 */
public class P1104 {

    //二叉树寻路
    /*
     *思路是先确定是第几层的第几个节点，然后再求路径
     *
     * */
    public List<Integer> pathInZigZagTree(int label) {

        //得到当前label所在层数
        int temp = label, index = 0;
        while ((temp = temp >> 1) > 0) {
            index++;
        }
        //得到label在当前层的位置索引，从0开始
        int mode = label - (1 << index);

        List<Integer> list = new ArrayList<>();

        while (index >= 0) {
            //获取指定行号 指定索引对应的值
            list.add(getValue(index, mode));
            //层数递减
            index--;
            //得到父节点在所在行的索引
            mode = (1 << index) - 1 - (mode / 2);
        }
        Collections.reverse(list);
        return list;
    }

    //获取指定行 指定索引位置的值
    private int getValue(int hang, int index) {
        int pow = 1 << hang;
        return pow + index;
    }

    public static void main(String[] args) {

        List<Integer> integers = new P1104().pathInZigZagTree(14);
        System.out.println(integers);

    }


}
