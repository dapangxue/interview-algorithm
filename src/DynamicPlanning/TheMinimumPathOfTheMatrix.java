package DynamicPlanning;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-14
 */
public class TheMinimumPathOfTheMatrix {
    public int minPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int row = m.length, col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = dp[j-1][0] + m[j][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int row = m.length;
        int col = m[0].length;

        boolean rowmore = row >= col;
        int more = Math.max(row, col);
        int less = Math.min(row, col);
        int size = rowmore ? col : row;
        int[] arr = new int[size];
        arr[0] = m[0][0];

        for (int i = 1; i < size; i++) {
            arr[i] = arr[i-1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j-1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less-1];
    }

    public static void main(String[] args) {
        TheMinimumPathOfTheMatrix theMinimumPathOfTheMatrix = new TheMinimumPathOfTheMatrix();
        System.out.println(theMinimumPathOfTheMatrix.minPathSum2(new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}}));
    }
}
