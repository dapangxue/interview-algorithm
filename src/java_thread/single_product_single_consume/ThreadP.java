package java_thread.single_product_single_consume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class ThreadP extends Thread {
    private Produce p;

    public ThreadP(Produce p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
