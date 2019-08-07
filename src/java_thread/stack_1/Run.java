package java_thread.stack_1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Produce p = new Produce(myStack);
        Consume c = new Consume(myStack);

        ThreadP a = new ThreadP(p);
        ThreadC b = new ThreadC(c);
        ThreadC b1 = new ThreadC(c);
        ThreadC b2 = new ThreadC(c);
        ThreadC b3 = new ThreadC(c);
        ThreadC b4 = new ThreadC(c);
        a.start();
        b.start();
        b1.start();
        b2.start();
        b3.start();
        b4.start();
    }
}
