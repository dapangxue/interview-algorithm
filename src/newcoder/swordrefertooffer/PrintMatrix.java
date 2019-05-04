package newcoder.swordrefertooffer;

import newcoder.baidu.first.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-1
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        // 获取矩阵的行和列
        int rows = matrix.length, columns = matrix[0].length;

        // 计算需要遍历的圈数
        int circle = rows > columns ? (columns + 1) / 2 : (rows + 1) / 2;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < circle; i++) {
            // 1.先从左到右打印
            for (int j = i; j < columns - i; j++) {
                list.add(matrix[i][j]);
            }
            // 2.从上到下打印
            for (int j = i + 1; j < rows - i; j++) {
                list.add(matrix[j][columns-i-1]);
            }
            // 3.从右到左打印
            for (int j = columns - 2 - i; j >= i; j--) {
                list.add(matrix[rows - 1 - i][j]);
            }
            // 4.从下向上打印
            for (int j = rows-2-i; j >=1+i;j--) {
                list.add(matrix[j][i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        PrintMatrix printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(matrix1));
    }
}
