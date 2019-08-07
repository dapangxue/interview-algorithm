package java_thread.stack_1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class ThreadP extends Thread {
    private Produce produce;

    public ThreadP(Produce produce) {
        this.produce = produce;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            produce.pushService();
        }
    }
}
