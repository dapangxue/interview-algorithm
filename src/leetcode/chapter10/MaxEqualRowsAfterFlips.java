package leetcode.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/2 0002
 */
public class MaxEqualRowsAfterFlips {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        return 0;
    }

    /**
     * 统计矩阵相等的行数
     * @param matrix
     * @return
     */
    public int matrixEqualRows(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i][j - 1]) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 统计具有相同列的下标
     * @param matrix
     * @return
     */
    public List<List<Integer>> matrixEqualsRows(int[][] matrix) {
        return null;
    }

    public int[][] transferMatrix(int[][] matrix) {
        int[][] a = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                a[j][i] = matrix[i][j];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        MaxEqualRowsAfterFlips m = new MaxEqualRowsAfterFlips();
//        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.deepToString(m.transferMatrix(a)));
    }
}
