package interview.zuo.chapter3;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-5-6
 */
public class CheckBalanceBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static boolean checkIsBalanceBinaryTree(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 0, res);
        return res[0];
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }

        int lH = getHeight(head.left, level + 1, res);
        if (res[0] == false) {
            return level;
        }

        int rH = getHeight(head.right, level + 1, res);
        if (res[0] == false) {
            return level;
        }

        if (Math.abs(rH - lH) > 1) {
            return level;
        }
        return Math.max(lH, rH);
    }
}
