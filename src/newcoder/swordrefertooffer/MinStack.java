package newcoder.swordrefertooffer;

import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-1
 */
public class MinStack {

    /**
     * 设计一个栈专门用来存储数据
     */
    private Stack<Integer> save;

    /**
     * 定义一个辅助栈，存储当前插入数据的最小值
     */
    private Stack<Integer> help;

    public MinStack() {
        this.save = new Stack<>();
        this.help = new Stack<>();
    }

    public void push(int node) {
        // save栈存储数据
        save.push(node);

        if (help.isEmpty() || node < help.peek()) {
            help.push(node);
        } else {
            help.push(help.peek());
        }
    }

    public void pop() {
        save.pop();
        help.pop();
    }

    public int top() {
        return save.pop();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(6);
        minStack.push(7);
        minStack.push(3);

        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

    public int min() {
        return help.peek();
    }
}
