package newcoder.netease;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Create by IDEA
 * https://www.nowcoder.com/practice/27f3672f17f94a289f3de86b69f8a25b?tpId=90&tqId=30785&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author wuxue
 * @date 19-2-13
 */
public class PileofChessPieces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入的n个旗子
        int n = scanner.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            y[j] = scanner.nextInt();
        }
        int[] res = helper(n, x, y);
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < n; k++) {
            stringBuilder.append(res[k] + " ");
        }
        System.out.println(stringBuilder.toString().trim());
        scanner.close();
    }

    private static int[] helper(int n, int[] x, int[] y) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    queue.offer(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                }
                int count = 0;
                int sum = 0;
                while (!queue.isEmpty()) {
                    sum += queue.poll();
                    res[count] = Math.min(res[count], sum);
                    count++;
                }
            }
        }
        return res;
    }
}
