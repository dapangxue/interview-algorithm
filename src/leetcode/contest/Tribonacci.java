package leetcode.contest;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 147场周赛
 * leetcode 斐波那切数列log(n)的写法
 * @author WuXue
 * @date 2019/7/28 0028
 */
public class Tribonacci {
    public int tribonacci(int n) {
        int[] init = new int[]{0, 1, 1, 2};
        if (n <= 3) {
            return init[n];
        }
        int[][] matrix = {{1, 1, 0}, {1, 0, 1}, {1, 0, 0}};
        int[][] t = matrixPow(matrix, n - 3);
        return 2 * t[0][0] + 1 * t[1][0] + 1 * t[2][0];
    }

    public int[][] multiMatrix(int[][] m, int[][] n) {
        int[][] result = new int[m.length][n[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                for (int k = 0; k < m[0].length; k++) {
                    result[i][j] += m[i][k] * n[k][j];
                }
            }
        }
        return result;
    }

    public int[][] matrixPow(int[][] matrix, int k) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        for (int i = 1; i <= k; i++) {
            result = multiMatrix(result, matrix);
        }
        return result;
    }

    public static void main(String[] args) {
        Tribonacci a = new Tribonacci();
        System.out.println(a.tribonacci(25));
//        int[][] t = new int[][]{{1, 1, 1}, {1, 1, 0}, {0, 0, 1}};
//        System.out.println(Arrays.deepToString(a.multiMatrix(t, t)));
    }
}
