package interview.zuo.chapter3;

import sun.reflect.generics.tree.Tree;

/**
 * Created with IntelliJ IDEA.
 * 左程云算法二叉树结点间的最大距离问题-P169
 * @author WuXue
 * @date 2019/5/29 0029
 */
public class MaxDistance {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /*
    思路：
    假设根节点是h，二叉树结点间的最远距离主要是：
    （1）h左子树的最远距离 lMax
    （2）h右子树的最远距离 rMax
    （3）h的左子树上离h.left的最远距离maxLeft, h的右子树上离h.right的最远距离maxRight(maxLeft + 1 + maxRight)

    比较以上三个的最大值就是最远的距离
     */

    /**
     * 计算最远的距离
     * @param head
     * @return
     */
    public static int maxDistance(TreeNode head) {
        int[] record = new int[1];
        return maxDistance(head, record);
    }

    /**
     * 计算最远的距离
     * @param head
     * @param record 用于存储到当前根节点的最远距离及Math.max(maxLeft + 1, maxRight + 1)
     * @return 返回当前二叉树最远的具体
     */
    public static int maxDistance(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }

        int lMax = maxDistance(head.left, record);
        // 到head.left的最大值
        int maxLeft = record[0];
        int rMax = maxDistance(head.right, record);
        // 到head.right的最大值
        int maxRight = record[0];

        int currentNodeMax = maxLeft + 1 + maxRight;
        // 到当前head节点的最大值
        record[0] = Math.max(maxLeft, maxRight) + 1;
        return Math.max(lMax, Math.max(currentNodeMax, rMax));
    }
}
