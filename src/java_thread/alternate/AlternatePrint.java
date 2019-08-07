package java_thread.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class AlternatePrint {

    public Lock lock;

    Condition condition1;
    Condition condition2;
    Condition condition3;

    int state = 1;

    public AlternatePrint() {
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }

    public void printFirst() {
        try {
            lock.lock();
            while (state != 1) {
                condition1.await();
            }
            System.out.println("1");
            state = 2;
            condition2.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public void printSecond() {
        try {
            lock.lock();
            while (state != 2) {
                condition2.await();
            }
            System.out.println("2");
            state = 3;
            condition3.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public void printThree() {
        try {
            lock.lock();
            while (state != 3) {
                condition3.await();
            }
            System.out.println("3");
            state = 1;
            condition1.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
}
