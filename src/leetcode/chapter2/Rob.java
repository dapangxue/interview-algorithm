package leetcode.chapter2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * LeetCode-198 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author WuXue
 * @date 2019/6/12 0012
 */
public class Rob {

    /**
     * 房屋没有循环的情况下
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        // 表示当前当前位置偷到的最大值
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[dp.length - 1];
    }

    /**
     * 房屋围成一圈
     * @param nums
     * @return
     */
//    public static int rob1(int[] nums) {
//        // dp[i]表示在nums[i]的偷到的最大值
//        int[] dp = new int[nums.length];
//        // 对于每一户人家，都会有一个最左边能到达和最右边能到达
//        int[] begin = new int[nums.length];
//        int[] end = new int[nums.length];
//
//        for (int i = 0, length = nums.length; i < length; i++) {
//            begin[i] = i + 2 >= length ? i + 2 - length : i + 2;
//            end[i] = i - 2 < 0 ? i - 2 + length : i - 2;
//        }
//
//        for (int i = 0, length = nums.length; i < length; i++) {
//            for (int k = begin[i]; k <= end[i]; k = getNextIndex(k, nums)) {
//                int t = 0;
//                for (int j = k; j <= end[i]; j = getNextIndex(getNextIndex(j, nums), nums)) {
//                    t += nums[j];
//                }
//                dp[i] = Math.max(dp[i], t);
//            }
//
//        }
//
//        System.out.println(Arrays.toString(dp));
//        return -1;
//
//    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public static int helper(int[] nums, int left, int right) {
        if ((right - left + 1) == 1) {
            return nums[left];
        }

        if ((right - left + 1) == 2) {
            return Math.max(nums[left], nums[right]);
        }

        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);

        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树的打家劫舍leetcode - 337
     * @param root
     * @return
     */
    public static int rob3(TreeNode root) {
        int result = 0;
        return Math.max(robInclude(root), robExclude(root));
    }

    public static int robInclude(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return robExclude(root.left) + robExclude(root.right) + root.val;
    }

    public static int robExclude(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return rob3(root.left) + rob3(root.right);
    }

    /**
     * 二叉树的打家劫舍 version2
     * @param root
     * @return
     */
    public static int rob4(TreeNode root) {
        int[] a = dfs(root);
        return Math.max(a[0], a[1]);
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        /*
        有两种方法计算偷到的最大值
        （1）不包含root的两个子树的打家劫舍的结果
        （2）包含root的两个子树不带子树根节点的打家劫舍的结果
         */
        int[] nums = new int[2];
        nums[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        nums[1] = root.val + left[0] + right[0];
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {2, 8, 5, 6, 4, 3};
        System.out.println(rob2(a));
    }
}
