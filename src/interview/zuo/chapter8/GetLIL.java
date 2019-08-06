package interview.zuo.chapter8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/8/6 0006
 */
public class GetLIL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 数组的长度
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        int max, min;
        int length = 1;

        for (int start = 0; start < N; start ++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int end = start; end < N; end++) {
                if (set.contains(array[end])) {
                    break;
                }
                max = Math.max(max, array[end]);
                min = Math.min(min, array[end]);
                if (max - min == end - start) {
                    length = Math.max(length, max - min + 1);
                }
            }
            set.clear();
        }
        System.out.println(length);
    }
}
