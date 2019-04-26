package newcoder.swordrefertooffer;

import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-15
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] copy = Arrays.copyOf(array, array.length);
        int count = helper(array, copy, 0, array.length-1);
        return count;
    }

    /**
     * 使用归并排序
     * @param array
     * @param copy
     * @param start
     * @param end
     * @return
     */
    private int helper(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        // 归并排序，长度减半
        int length = (end - start) / 2;
        int left = helper(copy, array, start, start + length);
        int right = helper(copy, array, start + length + 1, end);
        // 将i初始化为前半段最后一个数字的下标
        int i = start + length;
        // 将j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; --i) {
            copy[indexCopy--] = array[i];
        }
        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = array[j];
        }
        return left + right + count;
    }

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        System.out.println(inversePairs.InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
