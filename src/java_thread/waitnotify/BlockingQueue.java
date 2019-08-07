package java_thread.waitnotify;

import sun.security.provider.NativePRNG;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * 基于wait/notify实现的生产者-消费者模式
 * @author WuXue
 * @date 2019/8/7 0007
 */
public class BlockingQueue<T> {

    /**
     * 当前队列的最大容量
     */
    private int capacity;

    private Queue<T> queue;

    private int size;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<T>();
        this.size = 0;
    }

    public synchronized void put(T t) {
        while (size >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.offer(t);
        size++;
        notifyAll();
        System.out.println("生产者生产一个元素" + "当前剩余 ： " + queue.size() + "个元素");
    }

    public synchronized T take() {
        while (size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t = queue.poll();
        size--;
        notifyAll();
        System.out.println("消费者消费一个元素" + "当前剩余 : " + queue.size() + "个元素");
        return t;
    }

     static class Provider<T> implements Runnable {

        private BlockingQueue<T> queue;

        public Provider(BlockingQueue<T> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                queue.put((T) new Object());

            }

        }
    }

    static class Consumer<T> implements Runnable {
        private BlockingQueue<T> queue;

        public Consumer(BlockingQueue<T> queue) {
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
        BlockingQueue<Object> queue = new BlockingQueue<>(4);
        new Thread(new Provider<Object>(queue)).start();
        new Thread(new Consumer<Object>(queue)).start();
    }
}
