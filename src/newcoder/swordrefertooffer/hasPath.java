package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-10
 */
public class hasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int length = matrix.length;
        boolean[] visit = new boolean[length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols,
                           int i, int j, char[] str, int k,
                           boolean[] visit) {
        int index = i * cols + j;

        if (i < 0 || i >= rows || j < 0 || j >= cols
                || matrix[index] != str[k] || visit[index] == true) {
            return false;
        }
        if (k == str.length-1) {
            return true;
        }

        visit[index] = true;

        if (helper(matrix, rows, cols, i+1, j, str, k+1, visit)
                || helper(matrix, rows, cols, i, j+1, str, k+1, visit)
                || helper(matrix, rows, cols, i-1, j, str, k+1, visit)
                || helper(matrix, rows, cols, i, j-1, str, k+1, visit)) {
            return true;
        }
        visit[index] = false;
        return false;
    }
}
