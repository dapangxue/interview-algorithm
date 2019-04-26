package DynamicPlanning;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-14
 */
public class Fibonacci {
    /**
     * 两个矩阵相乘
     *
     * @param m1
     * @param m2
     * @return
     */
    private int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] result = new int[m1.length][m2[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    /**
     * 求矩阵m的p次方
     *
     * @param m
     * @param p
     * @return
     */
    private int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 先将res矩阵初始化为单位矩阵
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) == 1) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = matrixPower(base, n-2);
        return result[0][0] + result[1][0];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.f3(6));
    }
}
