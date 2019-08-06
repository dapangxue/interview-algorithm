package interview.zuo.chapter8;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/8/6 0006
 */
public class FindFixInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 矩阵的行
        int N = scanner.nextInt();
        // 矩阵的列
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        /**
         * version这种算法只是做了一个小优化，在最坏的情况下，时间复杂度依然为O(M*N)
         */
        /*
        int baseX;
        for (baseX = 0; baseX < N; baseX++) {
            if (matrix[baseX][M - 1] >= K) {
                break;
            }
        }

        int baseY;
        for (baseY = 0; baseY < M; baseY++) {
            if (matrix[N - 1][baseY] >= K) {
                break;
            }
        }

        for (int i = baseX; i < N; i ++) {
            for (int j = baseY; j < M; j++) {
                if (matrix[i][j] == K) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
         */

        /**
         * version2
         */
        int row = 0, col = M - 1;
        while (row < N && col >= 0) {
            if (matrix[row][col] > K) {
                col --;
            } else if (matrix[row][col] < K) {
                row ++;
            } else {
                System.out.println("Yes");
                return;
            }

        }
        System.out.printf("No");
    }
}
