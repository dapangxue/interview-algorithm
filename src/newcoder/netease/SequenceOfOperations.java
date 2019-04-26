package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-12
 */
public class SequenceOfOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入n个数字
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = n-1; i >= 0; i -= 2) {
            stringBuilder.append(a[i] + " ");
        }
        for (int i = (n & 1); i <= n-2; i += 2) {
            if (i == n-2) {
                stringBuilder.append(a[i]);
            } else {
                stringBuilder.append(a[i] + " ");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
