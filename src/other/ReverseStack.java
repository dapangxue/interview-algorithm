package other;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/23 0023
 */
public class ReverseStack {

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int tail = getAndRemoveTail(stack);
        reverseStack(stack);
        stack.push(tail);
    }

    public static int getAndRemoveTail(Stack<Integer> stack) {
        int t = stack.pop();
        if (stack.isEmpty()) {
            return t;
        }

        int tail = getAndRemoveTail(stack);
        stack.push(t);
        return tail;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

}

