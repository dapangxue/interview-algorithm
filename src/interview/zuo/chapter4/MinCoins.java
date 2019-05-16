package interview.zuo.chapter4;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 换钱的最小方法数
 * @author WuXue
 * @date 2019/5/9 0009
 */
public class MinCoins {
    /**
     * 换钱的最小方法数，本方法的时间复杂度是O(M * N),空间复杂度是O(M*N),在空间复杂度上可以优化
     * @param coins
     * @param k
     * @return
     */
    public static int minCoin(int[] coins, int k) {
        /*
        dp[i][j]表示使用钱币i构成j的最小值
        如果j = 0,表示使用钱币i构成0的最小方法数,也不需要钱币，所以dp[i][0] = 0;
         */
        // 定义动态规划数组，此处定义k + 1而不是k的原因是因为有钱币数等于0的情况
        int[][] dp = new int[coins.length][k + 1];
        // Arrays.sort(coins);
        for (int j = 1; j < k + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE;
            if (coins[0] <= j && dp[0][j - coins[0]] != Integer.MAX_VALUE) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }

        for (int j = 1; j < k + 1; j++) {
            for (int i = 1; i < coins.length; i++) {
                int left = Integer.MAX_VALUE;
                if (coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], left);
            }
        }

        for (int i = 0; i < coins.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[coins.length - 1][k] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][k];
    }

    /**
     * 压缩空间的写法
     * @param coins
     * @param k
     * @return
     */
    public static int minCoin2(int[] coins, int k) {
        if (coins == null || coins.length == 0 || k < 0) {
            return -1;
        }
        int[] dp = new int[k + 1];
        /*
        for (int i = 1; i < k + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        */
        for (int i = 1; i < k + 1; i ++) {
            dp[i] = Integer.MAX_VALUE;
            if (i >= coins[0] && dp[i - coins[0]] !=Integer.MAX_VALUE) {
                dp[i] = dp[i - coins[0]] + 1;
            }
        }
        for (int i = 1; i < coins.length; i ++) {
            for (int j = 1; j < k + 1; j ++) {
                int left = Integer.MAX_VALUE;
                if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    left = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    /*
    题目：给定货币数组coins，所有的值为正数，每个值仅代表一张钱的面值，
    再给定一个整数k代表要找的钱数，求组成k的最少货币数
     */

    /**
     *
     * @param coins
     * @param k
     * @return
     */
    public static int minCoin3(int[] coins, int k) {
        if (coins == null || coins.length == 0 || k < 0) {
            return -1;
        }

        int[][] dp = new int[coins.length][k + 1];
        for (int i = 1; i < k + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        if (coins[0] <= k) {
            dp[0][coins[0]] = 1;
        }

        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < coins.length; j++) {
                int left = Integer.MAX_VALUE;
                if (coins[j] <= i && dp[j - 1][i - coins[j]] != Integer.MAX_VALUE) {
                    left = dp[j - 1][i - coins[j]] + 1;
                }
                dp[j][i] = Math.min(left, dp[j - 1][i]);
            }
        }
        return dp[coins.length - 1][k] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][k];
    }

    public static int minCoin4(int[] coins, int k) {
        if (coins == null || coins.length == 0 || k < 0) {
            return -1;
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i < k + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        if (coins[0] <= k) {
            dp[coins[0]] = 1;
        }

        for (int i = 1; i < coins.length; i++) {
            // 逆序因为dp[i][j]的状态和dp[i - 1][j]这个状态有关
            for (int j = k; j >= 0; j--) {
                int left = Integer.MAX_VALUE;
                if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    left = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int k = 6;
        System.out.println(minCoin(a, k));
        System.out.println(minCoin2(a, k));

        System.out.println(minCoin3(a, k));
        System.out.println(minCoin4(a, k));

    }
}
