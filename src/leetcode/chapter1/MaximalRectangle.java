package leetcode.chapter1;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * leetcode-85题：https://leetcode-cn.com/problems/maximal-rectangle/
 * @author WuXue
 * @date 2019/6/5 0005
 */
public class MaximalRectangle {

    public static int maximalRectangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == 0 ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

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
        int[][] a = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(maximalRectangle(a));
    }
}
