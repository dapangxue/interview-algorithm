package leetcode.chapter11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * leetcode 1114 按序打印
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Foo {

    private Lock lock;

    private Condition condition1;
    private Condition condition2;
    private Condition condition3;
    // 用于标识当前的状态
    int state = 1;


    public Foo() {
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {

        try {
            lock.lock();
            while (state != 1) {
                condition1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state = 2;
            condition2.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            while (state != 2) {
                condition2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            state = 3;
            condition3.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            while (state != 3) {
                condition3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            state = 1;
            condition1.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

    }
}
