package SwordRefertoOffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/24 0024
 */
public class SimpleSolution {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 63股票的最大利润
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return -1;
        }

        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i - 1]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }

    /**
     * 找出二叉查找树中两个节点的最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p != null && q != null) {
            if (root.val >= p.val && root.val >= q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val <= p.val && root.val <= q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(a));
    }
}
