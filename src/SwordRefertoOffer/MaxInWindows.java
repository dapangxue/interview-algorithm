package SwordRefertoOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/19 0019
 */
public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            // 判断双端队列的末尾对应的值是否小于当前下标对应的值
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            // 如果队列头对应的下标已经超出窗口的范围，就将其抛出
            while (queue.peekFirst() <= i - size) {
                queue.pollFirst();
            }

            if (i >= size - 1) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxInWindows(new int[]{1, 2, 3}, 5));
    }
}
