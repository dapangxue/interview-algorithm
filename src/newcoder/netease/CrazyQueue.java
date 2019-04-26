package newcoder.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-14
 */
public class CrazyQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入学生人数
        int n = scanner.nextInt();

        // 存储学生的身高
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        // 1.将数组排序
        Arrays.sort(h);
        int maxValue = h[n-1];
        int minValue = h[0];
        int diff = maxValue - minValue;
        int minIndex = 1;
        int maxIndex = n-2;

        while (minIndex < maxIndex) {
            diff += maxValue - h[minIndex];
            diff += h[maxIndex] - minValue;
            maxValue = h[maxIndex--];
            minValue = h[minIndex++];
        }
        diff += Math.max(maxValue - h[minIndex], h[maxIndex] - minValue);
        System.out.println(diff);
    }

}
