package leetcode.chapter2;

/**
 * Created with IntelliJ IDEA.
 * leetcode-124题
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author WuXue
 * @date 2019/6/11 0011
 */
public class MaxPathSum {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static int maxPathSum(TreeNode head) {
        return helper(head, new int[1]);
    }

    /**
     * 返回以head为子树的最大路径和，和到达head的最大值
     * @param head
     * @param record 数组中只有一个元素，表示到达当前根节点的最大值
     * @return
     */
    public static int helper(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return Integer.MIN_VALUE;
        }

        /*
        思路：
        因为要获取最大的路径和，只会有三种情况：
        最大和来自于左子树
        最大和来自于右子树
        到达根节点的左子节点的最大值 + 根节点右子节点的最大值 + 根节点的值
         */

        int leftMaxSum = helper(head.left, record);
        int maxFromLeft = Math.max(record[0], 0);

        int rightMaxSum = helper(head.right, record);
        int maxFromRight = Math.max(record[0], 0);

        int maxSum = maxFromLeft + maxFromRight + head.value;
        record[0] = Math.max(maxFromLeft, maxFromRight) + head.value;
        return Math.max(leftMaxSum, Math.max(rightMaxSum, maxSum));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
        System.out.println(maxPathSum(root));
        System.out.println(root.hashCode());
    }
}
