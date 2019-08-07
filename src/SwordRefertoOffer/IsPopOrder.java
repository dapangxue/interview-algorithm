package SwordRefertoOffer;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/23 0023
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        // 出栈数组的索引
        int index = 0;

        Stack<Integer> stack = new Stack<>();
        for (int x : pushA) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
