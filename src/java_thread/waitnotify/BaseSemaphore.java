package java_thread.waitnotify;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/8/7 0007
 */
public class BaseSemaphore {

    private Semaphore notFull = new Semaphore(10);
    private Semaphore notEmpty = new Semaphore(0);
    private Semaphore lock = new Semaphore(1);
    private Integer count = 0;

    public void put() {
        try {
            notFull.acquire();
            lock.acquire();
            count++;
            System.out.println("生产者生产一个元素，当前队列中有" + count + "个元素");
        } catch (InterruptedException e) {

        } finally {
            notEmpty.release();
            lock.release();
        }
    }

    public void take() {
        try {
            notEmpty.acquire();
            lock.acquire();
            count--;
            System.out.println("消费者消费了一个元素，当前队列中有" + count + "个元素");
        } catch (InterruptedException e) {

        } finally {
            notFull.release();
            lock.release();
        }
    }

    class Provider implements Runnable {

        private BaseSemaphore queue;

        public Provider(BaseSemaphore queue) {
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
        private BaseSemaphore queue;

        public Consumer(BaseSemaphore queue) {
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
        BaseSemaphore queue = new BaseSemaphore();
        new Thread(queue.new Provider(queue)).start();
        new Thread(queue.new Consumer(queue)).start();
    }
}
