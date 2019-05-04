package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 * 本题是网易2017年校招在线编程题目
 * 题目来源：https://www.nowcoder.com/practice/661c49118ca241909add3a11c96408c8?tpId=85&tqId=29830&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * @author wuxue
 * @date 19-1-1
 */
public class Choir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取学生的个数
        int n = scanner.nextInt();

        // 定义数组存取学生的能力值
        int[] a = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i] = scanner.nextInt();
        }
        // 需要选取k个学生
        int k = scanner.nextInt();
        // 位置编号差不超过d
        int d = scanner.nextInt();

        // max[i][j]表示选中了i个学生，以第j个结尾，所产生的最大乘积
        long[][] max = new long[k+1][n+1];
        long[][] min = new long[k+1][n+1];

        long res = Integer.MIN_VALUE;

        // 核心算法
        for (int i = 1; i < n+1; i++) {
            max[1][i] = a[i];
            min[1][i] = a[i];

            // 不断循环选择k个人
            for (int j = 2; j <= k; j++) {
                for (int m = i-1; m > 0 && i - m <= d; m--) {
                    max[j][i] = Math.max(max[j][i], Math.max(max[j-1][m]*a[i], min[j-1][m]*a[i]));
                    min[j][i] = Math.min(min[j][i], Math.min(max[j-1][m]*a[i], min[j-1][m]*a[i]));
                }
            }
            res = Math.max(res, max[k][i]);
        }
        System.out.println(res);
    }
}
