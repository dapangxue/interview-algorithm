package leetcode.chapter1;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/31 0031
 */
public class LargestRectangleArea {
    public static int largestRectangleArea(int[] height) {
        /*
        采用单调栈的思想
        思路：把完全包含各个柱状图的矩形的最大面积求出来
         */
        Stack<Integer> stack = new Stack<>();
        int[] newHeight = new int[height.length + 1];
        System.arraycopy(height, 0, newHeight, 0, height.length);
        newHeight[height.length] = 0;
        int max = 0;

        for (int i = 0, length = newHeight.length; i < length; i++) {
            // 当当前元素小于等于栈顶元素
            while (!stack.isEmpty() && newHeight[i] <= newHeight[stack.peek()]) {
                int h = newHeight[stack.pop()];
                // int width = i - stack.peek() - 1;
                max = Math.max(max, stack.isEmpty() ? h * i : h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // 单调栈，从小到大存储
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0, length = heights.length; i < length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int k = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - l - 1) * heights[k]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int k = stack.pop();
            int l = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (heights.length - l - 1) * heights[k]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        int[] b = {1, 1};
        System.out.println(largestRectangleArea(b));
    }
}
