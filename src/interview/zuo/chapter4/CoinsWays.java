package interview.zuo.chapter4;

import java.util.Map;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-5-14
 */
public class CoinsWays {
    /**
     * 首先采用暴力解法，递归的方式
     * 比如对于{5， 10， 25， 1}，aim = 1000
     * 用0张5元的货币，剩下的1000从{10, 25, 1}中凑齐
     * 用1张5元的货币，剩下的995从{10, 25, 1}中凑齐
     * ...
     * 用200张5元的货币，剩下的0元从{10, 25, 1}中凑齐
     * @param arr
     * @param aim
     * @return
     */
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    /**
     * 方法2：记忆搜索算法，优化了暴力解法
     * @param arr
     * @param aim
     * @return
     */
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length][aim + 1];
        return process(arr, 0, aim);
    }
    /**
     * 采用记忆搜索算法, 此处不能使用map,因为需要的key有两个
     * @param arr
     * @param index
     * @param aim
     * @param map
     * @return
     */
    public static int process1(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                int mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process1(arr, index + 1, aim - arr[index] * i, map);
                }
            }
            map[index][aim] = res == 0 ? -1  : res;
        }
        return res;
    }

    /**
     * 方法3：动态规划方法
     * @param arr
     * @param aim
     * @return
     */
    public static int coins3(int[] arr, int aim) {
        // dp[i][j]表示构成当前货币j的方法数
        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; arr[0] * i < dp[0].length; i++) {
            dp[0][arr[0] * i] = 1;
        }

        /*
        思路：
        1、k从0开始算，完全不使用arr[i]货币，那么aim有a[0...i - 1]满足
        2、k从1开始算，使用一次arr[i]货币，那么aim - 1 * a[i]由a[0...i - 1]满足
        。。。
        3、k张a[i]货币，剩下的aim - k * a[i]有a[0...i - 1]满足，方法数为dp[i - 1][aim - k * a[i]]
         */
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                int num = 0;
                for (int k = 0; k * arr[i] <= j; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[dp.length - 1][aim];
    }

    public static int coins4(int[] coins, int aim) {
        int[] dp = new int[aim + 1];

        for (int i = 0; i * coins[0] <= aim; i++) {
            dp[i * coins[0]] = 1;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[aim];
    }

    public static void main(String[] args) {
        int[] coins = {5, 10, 25, 1};
        int aim = 1000;
        System.out.println(coins1(coins, 1000));
        System.out.println(coins2(coins, 1000));
        System.out.println(coins3(coins, 1000));
        System.out.println(coins4(coins, 1000));
    }
}
