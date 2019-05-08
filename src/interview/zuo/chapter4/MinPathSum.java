package interview.zuo.chapter4;

import java.util.Arrays;

/**
 * Create by IDEA
 * 左程云算法-计算路径的最小路径和P187
 * @author wuxue
 * @date 19-5-8
 */
public class MinPathSum {
    /**
     * 计算矩阵的最小的最小路径和
     * 这种思路的时间复杂度为O(M * N)额外的空间复杂度也为O(M * N)
     * @param m
     * @return
     */
    public static int minPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        // dp[i][j]表示从(0, 0)到达(i, j)时最小的路径和
        int[][] dp = new int[m.length][m[0].length];

        dp[0][0] = m[0][0];
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] += dp[0][i - 1] + m[0][i];
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }

//        for (int i = 0; i < m.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[m.length - 1][m[0].length - 1];
    }

    /**
     * 计算矩阵的最小的最小路径和，空间复杂度优化为O(min{M, N})
     * @param m
     * @return
     */
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int row = m.length;
        int col = m[0].length;
        int more = Math.max(row, col);
        int less = Math.min(row, col);
        boolean rowmore = row >= col ? true : false;
        int[] dp = new int[less];
        dp[0] = m[0][0];

        for (int i = 1; i < less; i++) {
            dp[i] = rowmore ? dp[i - 1] + m[0][i] : dp[i - 1] + m[i][0];
        }
        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + (rowmore ?  + m[i][j] : m[j][i]);
            }
        }
        return dp[less - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPathSum(matrix));
        System.out.println(minPathSum1(matrix));
    }
}
