package leetcode.chapter2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/14 0014
 */
public class CalculateMinimumHP {

    /**
     * 确认骑士所需的最低的健康点数
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        // dp[i][j]表示骑士要走上（i,j）位置，且从该位置选一条最优的路径，走到右下角，最少需要具备的血量
        int[][] dp = new int[row--][col--];

        // 得到最右下角的需要到达（row - 1, col - 1）的位置的血量
        dp[row][col] = dungeon[row][col] >= 0 ? 1 : -dungeon[row][col] + 1;
        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(dp[row][j + 1] - dungeon[row][j], 1);
        }

        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - dungeon[i][col], 1);
            for (int j = col - 1; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(a));
    }

}
