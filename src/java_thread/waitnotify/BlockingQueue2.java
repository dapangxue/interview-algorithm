package java_thread.waitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/8/7 0007
 */
public class BlockingQueue2 {
    private Integer count = 0;
    private final Integer FULL = 10;

    private Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public void put() {
        lock.lock();
        try {
            while (count >= FULL) {
                notFull.await();
            }
            count++;
            System.out.println("生产者生产一个元素，此时队列中有" + count + "个元素");
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            count--;
            System.out.println("消费者消费了一个元素，此时队列中有" + count + "个元素");
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.lock();
        }
    }

    class Provider implements Runnable {

        private BlockingQueue2 queue;

        public Provider(BlockingQueue2 queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                queue.put();
            }
        }
    }

    class Consumer implements Runnable {
        private BlockingQueue2 queue;

        public Consumer(BlockingQueue2 queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                queue.take();
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue2 queue = new BlockingQueue2();

        new Thread(queue.new Provider(queue)).start();
        new Thread(queue.new Consumer(queue)).start();
    }
}
