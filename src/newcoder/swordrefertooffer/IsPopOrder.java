package newcoder.swordrefertooffer;

import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-1
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int []popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int x : pushA) {
            stack.push(x);

            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return index == popA.length;

    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,3,5,1,2};
        System.out.println(isPopOrder.IsPopOrder(pushA, popA));
    }
}
