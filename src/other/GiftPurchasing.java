package other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/4 0004
 */
public class GiftPurchasing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总金额
        int money  = Integer.valueOf(scanner.nextLine());

        String[] price = scanner.nextLine().trim().split(" ");
        int[] giftPrice = new int[price.length];
        for (int i = 0; i < giftPrice.length; i++) {
            giftPrice[i] = Integer.valueOf(price[i]);
        }

        String[] h = scanner.nextLine().trim().split(" ");
        int[] heat = new int[h.length];
        for (int i = 0; i < heat.length; i++) {
            heat[i] = Integer.valueOf(h[i]);
        }

        // dp[i][j]表示前i种物品恰放入一个容量为j的背包中所产生的的最大的价值
        int[][] dp = new int[giftPrice.length][money + 1];
        for (int j = 1; j < dp[0].length; j++) {
            if (j < giftPrice[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = heat[0];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j > giftPrice[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - giftPrice[i]] + heat[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[giftPrice.length - 1][money]);
    }

}
