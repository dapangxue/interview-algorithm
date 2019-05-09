package interview.zuo.chapter4;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 换钱的最小方法数
 * @author WuXue
 * @date 2019/5/9 0009
 */
public class MinCoins {
    public static int minCoin(int[] coins, int k) {
        /*
        dp[i][j]表示使用钱币i构成j的最小值
        如果j = 0,表示使用钱币i构成0的最小方法数
         */
        // 定义动态规划数组
        int[][] dp = new int[coins.length][k + 1];
        Arrays.sort(coins);
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
        int[] dp = new int[k + 1];
        for (int i = 1; i < k + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 10};
        int k = 10;
        System.out.println(minCoin(a, k));
        System.out.println(minCoin2(a, k));
    }
}
