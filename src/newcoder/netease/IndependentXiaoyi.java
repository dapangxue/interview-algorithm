package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-12
 */
public class IndependentXiaoyi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = -0x12345678;
        int[] a = new int[4];

        for (int i = 0; i < 4; i++) {
            a[i] = scanner.nextInt();
        }

        int day = 0;

        // 当小易有水果的时候
        if (a[1] != 0 && a[1] * a[0] < a[2]) {
            day = a[1];
        } else {
            System.out.println(a[2]/a[0]);
        }

        // 计算剩余的钱,此时水果已经吃完，小易需要同时付房租和水果钱
        a[2] -= a[0] * a[1];
        // 小易一天的支出
        int pay = a[0] + a[3];
        System.out.println(day + (a[2] / pay));
    }
}
