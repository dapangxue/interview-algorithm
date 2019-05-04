package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-15
 */
public class MinimumMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        int res = 0;
        while (count < 3) {
            res++;
            count = 0;
            for (int x : arr) {
                if (res % x == 0) {
                    count++;
                }
            }
        }
        System.out.println(res);
    }
}
