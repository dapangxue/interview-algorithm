package leetcode.chapter10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/9 0009
 */
public class SufficientSubset {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, root.val);
    }

    /**
     * 通过递归计算到达每个结点时的值，如果当前节点是叶结点，且小于limit
     * 暂时没想明白哪里有问题
     * @param root
     * @param limit
     * @param sum
     * @return
     */
    public static TreeNode helper(TreeNode root, int limit, long sum) {
        if (root.left == null && root.right == null) {
            if (sum < limit) {
                return null;
            } else {
                return root;
            }
        }
        if (root.left != null)
            root.left = helper(root.left, limit, sum + root.left.val);

        if (root.right != null)
            root.right = helper(root.right, limit, sum + root.right.val);
        if (root.left == null && root.right == null && sum < limit) {
            root = null;
        }
        return root;
    }

    public static TreeNode helper1(TreeNode root, int limit, int preSum) {
        if (root == null) {
            return null;
        }

        if (maxPathSum(root) + preSum < limit) {
            return null;
        }

        root.left = helper1(root.left, limit, preSum + root.val);
        root.right = helper1(root.right, limit, preSum + root.val);
        return root;
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxPathSum(root.left), maxPathSum(root.right)) + root.val;
    }
}
