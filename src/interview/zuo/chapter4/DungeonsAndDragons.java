package interview.zuo.chapter4;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 第四章-龙与地下城游戏问题
 * 本算法的时间复杂度为O(M * N),额外的空间复杂度为O(M * N)
 * @author WuXue
 * @date 2019/5/3 0003
 */
public class DungeonsAndDragons {

    /**
     * 返回骑士的初始血量
     * @param map 城堡的地图
     * @return
     */
    public static int getInitHP(int[][] map) {
        if (map == null || map.length == 0 || map[0] == null || map[0].length == 0) {
            return 1;
        }

        int row = map.length;
        int col = map[0].length;
        // dp[i][j]表示到达城堡的i和j这个位置时需要的最少的血量(存活的最少血量)即dp[i][j] + map[i][j] >= 1
        int[][] dp = new int[row--][col--];
        // 首先计算到达终点的最少的血量
        dp[row][col] = map[row][col] > 0 ? 1 : -map[row][col] + 1;
        // 首先计算在最后一行路径是的dp[row][j]的血量，此时骑士只能向右行走
        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = Math.max(1, dp[row][i + 1] - map[row][i]);
        }
        // 2、再次计算在最后一列的dp[i][col]的血量，此时骑士只能向下行走
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - map[i][col]);
            for (int j = col - 1; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - map[i][j], 1);
                int down = Math.max(dp[i + 1][j]- map[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] map = {{-2, -3, 3}, {-5, -10, 1}, {0, 30, -5}};
        getInitHP(map);
    }
}
