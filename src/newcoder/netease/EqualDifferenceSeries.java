package newcoder.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by IDEA
 * 题目来源：https://www.nowcoder.com/practice/e11bc3a213d24fc1989b21a7c8b50c3f?tpId=90&tqId=30781&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author wuxue
 * @date 19-1-17
 */
public class EqualDifferenceSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 有多少个数字
        int n = scanner.nextInt();
        // 构建数组
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        // 将数组排序
        Arrays.sort(array);
        int diff = array[1] - array[0];
        for (int j = 1, length = array.length; j < length; j++) {
            if ((array[j] - array[j-1]) != diff) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
