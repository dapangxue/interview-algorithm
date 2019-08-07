package java_thread.single_product_single_consume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Consume {
    private String lock;

    public Consume(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                Thread.sleep(1000);
                if (ValueObject.value.equals("")) {
                    System.out.println("消费者 " + Thread.currentThread().getName() + " WAITING*");
                    lock.wait();
                }

                System.out.println("消费者 " + Thread.currentThread().getName() + " RUNNABLE了");
                System.out.println("get的值是" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
