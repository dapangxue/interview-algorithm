package newcoder.swordrefertooffer;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-11
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        int start = 0;
        int end = array.length-1;

        while (array[start] >= array[end]) {
            if (end - start == 1) {
                return array[end];
            }
            int mid = (start + end) / 2;

            if (array[start] == array[mid] && array[mid] == array[end]) {
                return order(array, start, end);
            }

            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return 0;
    }

    private int order(int[] array, int start, int end) {
        int result = Integer.MAX_VALUE;
        for (int i = start+1; i < end; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray min = new MinNumberInRotateArray();
        int[] a = new int[]{1, 0, 1, 1, 1};
        int[] b = new int[]{1, 1, 1, 0, 1};
        System.out.println(min.minNumberInRotateArray(a));
        System.out.println(min.minNumberInRotateArray(b));
    }
}
