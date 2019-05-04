package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-10
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visit = new boolean[rows][cols];
        return helper(threshold, rows, 0, cols, 0, visit);
    }

    private int helper(int threshold, int rows, int i,
                       int cols, int j, boolean[][] visit) {
        if (i < 0 || i >= rows || j < 0 || j > cols
                || visit[i][j] == true || bitCount(i) + bitCount(j) > threshold) {
            return 0;
        }
        visit[i][j] = true;
        return helper(threshold, rows, i+1, cols, j, visit)
                + helper(threshold, rows, i, cols, j+1, visit)
                + helper(threshold, rows, i-1, cols, j, visit)
                + helper(threshold, rows, i, cols, j-1, visit) + 1;
    }

    private int bitCount(int t) {
        int count = 0;
        while (t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }
}
