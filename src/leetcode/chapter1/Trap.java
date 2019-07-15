package leetcode.chapter1;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * LeetCode第42题
 * @author WuXue
 * @date 2019/5/31 0031
 */
public class Trap {

    /**
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int result = 0;

        /*
        说明：暴力法，时间复杂度为O(N * N)，空间复杂度为O(1)，
        思路：从当前位置开始向左或向右找两侧的最大值，当前位置的容量受限于maxLeftHeight和maxRightHeight中最小的那个
         */
        for (int i = 1, length = height.length; i < length - 1; i++) {
            int maxLeftHeight = height[i], maxRightHeight = height[i];

            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeftHeight) {
                    maxLeftHeight = height[j];
                }
            }
            for (int j = i + 1; j < length; j++) {
                if (height[j] > maxRightHeight) {
                    maxRightHeight = height[j];
                }
            }
            result += Math.min(maxLeftHeight, maxRightHeight) - height[i];
        }
        return result;
    }


    public static int trap1(int[] height) {
        int result = 0;
        /*
        新思路：
        保存到当前节点的左边的最大值，右边的最大值
        虽然复杂度减小了，但是额外空间复杂度增加由O(1)变成O(N)
         */
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1, length = maxLeft.length; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[maxRight.length - 1] = height[height.length - 1];
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        for (int i = 0, length = height.length; i < length; i++) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }

    public static int trap2(int[] height) {
        int result = 0;
        /*
        采用栈，时间复杂度和空间复杂度都是O(n)
         */
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] >= height[stack.peek()]) {
                int t = stack.pop();
                if (!stack.isEmpty()) {
                    int distance = current - stack.peek() - 1;
                    int h = Math.min(height[current], height[stack.peek()]) - height[t];
                    result += distance * h;
                }
            }

            stack.push(current++);
        }
        return result;
    }

    public static int trap3(int[] height) {
        int result = 0;
        /*
        采用双指针， left和right，先处理height[left]和height[right]较小的那边，
        较小的那边再和那一侧的leftMax/rightMax相比较，如果比那一侧原本的最大值小，则说明可以存下雨水
        而且leftMax/rightMax表示当前一侧的最大值，肯定小于对应的height[right]和height[right]
         */
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    result += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    result += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(a));
        System.out.println(trap1(a));
        System.out.println(trap2(a));
        System.out.println(trap3(a));
    }
}
