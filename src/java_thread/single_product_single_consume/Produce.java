package java_thread.single_product_single_consume;

/**
 * Created with IntelliJ IDEA.
 * 单生产单消费实现
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Produce {
    private String lock;

    public Produce(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                Thread.sleep(1000);
                // 如果当前ObjectValue对象有值
                if (!ValueObject.value.equals("")) {
                    System.out.println("生产者" + Thread.currentThread().getName() + " WAITING了*");
                    lock.wait();
                }
                System.out.println("生产者" + Thread.currentThread().getName() + " RUNNABLE了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是" + value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
