package java_thread.single_product_single_consume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        String lock = "wuxue";
        // 正常的生产者消费者状态
        /*
        Produce p = new Produce(lock);
        ThreadP a = new ThreadP(p);

        Consume c = new Consume(lock);
        ThreadC b = new ThreadC(c);

        a.start();
        b.start();

         */

        // 生产者消费者的假死状态（生产者消费者线程都进入WAITING状态）,出现这种假死的主要原因就是有可能连续唤醒同类
        Produce p = new Produce(lock);
        Consume c = new Consume(lock);
        ThreadP[] pThread = new ThreadP[2];
        ThreadC[] cThread = new ThreadC[2];
        for (int i = 0; i < 2; i++) {
            pThread[i] = new ThreadP(p);
            pThread[i].setName("生产者 " + (i + 1));
            cThread[i] = new ThreadC(c);
            cThread[i].setName("消费者" + (i + 1));
            pThread[i].start();
            cThread[i].start();
        }

        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
        }
    }
}
