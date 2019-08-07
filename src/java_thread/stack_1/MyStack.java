package java_thread.stack_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class MyStack {

    private List list = new ArrayList();

    public synchronized void push() {
        try {
            while (list.size() == 0) {
                this.wait();
            }

            list.add("anyString = " + Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException e) {

        }
    }

    public synchronized String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                this.wait();
            }

            returnValue = String.valueOf(list.get(0));
            list.remove(0);
            this.notifyAll();
            System.out.println("pop = " + list.size());
        } catch (InterruptedException e) {

        }
        return returnValue;
    }

}
