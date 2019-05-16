package interview.zuo.chapter4;

/**
 * Create by IDEA
 * 最长递增子序列-P202
 * @author wuxue
 * @date 19-5-14
 */
public class MaxSubArray {

    /**
     * 通过动态规划得到 dp数组
     * @param a
     * @return
     */
    public static int getLength(int[] a) {
        //  dp[i]表示以ａ[i]结尾的最长递增子序列的长度
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1, length = a.length; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[a.length - 1];
    }

    public static void main(String[] args) {

    }
}
