package interview.zuo.other;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * 题目描述：有一个数组，构成一个圆环，最后一个元素连接数组的第一个元素,数组中可能有重复的元素
 * 要求： 1、相邻的两个元素一定可以看到
 *       2、不相邻的两个元素之间都小于这两个元素的最小值，那么也可以相互看到
 * 求有多少对这样的元素可以被看到
 * @author WuXue
 * @date 2019/6/6 0006
 */
public class AnnulusPair {

    static class Pair {
        int value;
        int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static int nextIndex(int size, int i) {
        return i < (size - 1) ? i + 1 : 0;
    }

    public static long getCombinationValue(int c, int k) {
        return (long) c * (long) (c - 1) / (long) k;
    }

    public static long annulusPair(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }

        int length = a.length;

        Stack<Pair> stack = new Stack<>();
        // 查找数组中出现最大值的第一个下标
        int maxValueIndex = 0;
        for (int i = 1; i < length; i++) {
            if (a[i] > a[maxValueIndex]) {
                maxValueIndex = i;
            }
        }

        long result = 0L;

        // 开始单调栈
        int value = a[maxValueIndex];
        stack.push(new Pair(value));
        int index = nextIndex(a.length, maxValueIndex);
        while (index != maxValueIndex) {
            int t = a[index];
            while (!stack.isEmpty() && t > stack.peek().value) {
                Pair p = stack.pop();
                // 获取相互之间排列的值
                result += getCombinationValue(p.times, 2) + p.times * 2;
            }

            if (!stack.isEmpty() && t == stack.peek().value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(t));
            }
            index = nextIndex(length, index);
        }

        // 遍历完数组后，如果栈中不为空的处理方式
//        while (!stack.isEmpty()) {
//            if (stack.size() > 2) {
//                Pair p = stack.pop();
//                long combinationValue = getCombinationValue(p.times, 2);
//                result += combinationValue + p.times * 2;
//            } if (stack.size() == 2) {
//                Pair p = stack.pop();
//                long combinationValue = getCombinationValue(p.times, 2);
//                result += combinationValue + (stack.peek().times >= 2 ? p.times * 2 : p.times);
//            } else {
//                Pair p = stack.pop();
//                result += getCombinationValue(p.times, 2);
//            }
//        }

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            result += getCombinationValue(p.times, 2);
            if (!stack.isEmpty()) {
                if (stack.size() >= 2) {
                    result += 2 * p.times;
                } else if (stack.size() == 1) {
                    result += stack.peek().times > 1 ? p.times * 2 : p.times;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 4, 4, 6, 6, 6};
        System.out.println(annulusPair(a));
    }
}
