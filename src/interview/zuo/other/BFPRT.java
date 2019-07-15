package interview.zuo.other;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * BFPRT算法主要用于找出数组中的第k大的数
 * 最简单的办法就是首先将数组排序，然后可以找出第k大的数，但是数组排序的最小的时间复杂度也是O（nlogn）,所以采用这种思路的时间复杂度为O（nlogn）
 * 但是对于BFPRT算法，时间复杂度可以达到O（n）
 * @author WuXue
 * @date 2019/7/7 0007
 */
public class BFPRT {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6, 0, 9, 2, 3};
        System.out.println(bfprt(a, 4, 0, a.length - 1));
    }

    public static int bfprt(int[] a, int k, int begin, int end) {
        if (begin == end) {
            return a[begin];
        }
        // 找到中位数中的中位数
        int pivot = getMedianOfMedians(a, begin, end);
        int[] p = partition(a, begin, end, pivot);
        if (k >= p[0] && k <= p[1]) {
            return a[k];
        } else if (k < p[0]) {
            return bfprt(a, k, begin, p[0] - 1);
        } else {
            return bfprt(a, k, p[1] + 1, end);
        }
    }

    public static int[] partition(int[] arr, int begin, int end, int partition) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;

        while (cur != big) {
            if (arr[cur] < partition) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > partition) {
                swap(arr, --big, cur);
            } else {
                cur++;
            }
        }

        return new int[]{small + 1, big - 1};
    }

    /**
     * 获取中位数中中位数
     * @param a
     * @param begin
     * @param end
     * @return
     */
    public static int getMedianOfMedians(int[] a, int begin, int end) {
        // 获取数组范围的总长度
        int length = end - begin + 1;
        boolean sure = length % 5 == 0 ? true : false;

        // 构造一个中位数数组，用于存储数组的中位数
        int[] median;
        if (sure) {
            median = new int[length / 5];
        } else {
            median = new int[length / 5 + 1];
        }

        int start = begin;
        for (int i = 0; i < median.length - 1; i ++) {
            median[i] = getMedian(a, start, start + 4);
            start += 5;
        }

        median[median.length - 1] = getMedian(a, start, end);
        return getMedian(median, 0, median.length - 1);
    }

    /**
     * 获取数组的中位数
     * @param a
     * @param begin
     * @param end
     * @return
     */
    public static int getMedian(int[] a, int begin, int end) {
        int[] temp = new int[end - begin + 1];
        System.arraycopy(a, begin, temp, 0, temp.length);
        // 插入排序
        for (int i = 1; i < temp.length; i++) {
            for (int j = i; j > 0; j--) {
                if (temp[j] < temp[j - 1]) {
                    swap(temp, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return temp[(end - begin) / 2];
    }

    // 交换数组的元素
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
