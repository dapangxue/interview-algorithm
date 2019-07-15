package leetcode.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/5 0005
 */
public class PancakeSort {
    public static List<Integer> pancakeSort(int[] A) {
        int length = A.length;
        Integer[] t = new Integer[length];
        for (int i = 0; i < t.length; i++) {
            t[i] = i + 1;
        }

        // Arrays.sort(a, t),将a按照t的顺序排序
        Arrays.sort(t, (i, j) -> A[j - 1] - A[i - 1]);

        List<Integer> result = new ArrayList<>();
        for (Integer x : t) {
            for (Integer k : result) {
                if (x <= k) {
                    x = k - x + 1;
                }
            }
            result.add(x);
            result.add(length--);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 1};
        System.out.println(pancakeSort(a));
    }
}
