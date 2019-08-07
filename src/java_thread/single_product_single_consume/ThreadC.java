package java_thread.single_product_single_consume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class ThreadC extends Thread {

    private Consume c;

    public ThreadC(Consume c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
