package interview.zuo.other;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * 滑动窗口题目，找出每个窗口内的最大值
 * @author WuXue
 * @date 2019/7/9 0009
 */
public class SlideWindow {
    /**
     *
     * @param a
     * @param k
     * @return
     */
    public static int[] slideWindow(int[] a, int k) {
        // 假设窗口的值大于数组的长度
        if (k > a.length) {
            return new int[]{};
        }

        // 其实可以理解为一个单调队列
        Deque<Integer> dequeue = new LinkedList<>();
        // 窗口的最大值一共有a.length - k + 1个
        int[] maxWindowValue = new int[a.length - k + 1];
        int index = 0;

        for (int i = 0, length = a.length; i < length; i++) {
            // 单调队列，如果碰到队列末尾的值小于当前值，需要将它抛出队列
            while(!dequeue.isEmpty() && a[dequeue.peekLast()] <= a[i]) {
                dequeue.pollLast();
            }
            dequeue.offerLast(i);
            // 如果当前队列的队尾元素和队头元素相差>k个元素，那么队头元素需要抛出队列
            if (i - dequeue.peekFirst() > k - 1) {
                dequeue.pollFirst();
            }

            if (i >= k - 1) {
                maxWindowValue[index++] = a[dequeue.peekFirst()];
            }
        }
        return maxWindowValue;
    }

    /**
     * 返回a的子数组中满足最大值减去最小值小于num的子数组的个数（没理解）
     * @param a
     * @param num
     * @return
     */
    public static int findLessThanNumCount(int[] a, int num) {
        Deque<Integer> qmin = new LinkedList<>();
        Deque<Integer> qmax = new LinkedList<>();

        int start = 0;
        int end = 0;
        int count = 0;
        while (start < a.length) {
            while (end < a.length) {
                while (!qmin.isEmpty() && a[qmin.peekLast()] >= a[end]) {
                    qmin.pollLast();
                }
                qmin.offerLast(end);
                while (!qmax.isEmpty() && a[qmax.peekLast()] <= a[end]) {
                    qmax.pollLast();
                }
                qmax.offerLast(end);

                while (a[qmax.peekFirst()] - a[qmin.peekFirst()] <= num) {
                    break;
                }
                end++;
            }

            if (qmin.peekFirst() == start) {
                qmin.pollFirst();
            }

            if (qmax.peekFirst() == start) {
                qmax.pollFirst();
            }
            count += end - start;
            start++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 5, 1, 7, 12, 9};
        System.out.println(Arrays.toString(slideWindow(a, 5)));
    }
}
