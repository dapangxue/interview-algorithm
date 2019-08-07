package java_thread.alternate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Run {
    public static void main(String[] args) {
        AlternatePrint a = new AlternatePrint();

        Thread1[] thread1s = new Thread1[5];
        Thread2[] thread2s = new Thread2[5];
        Thread3[] thread3s = new Thread3[5];

        for (int i = 0; i < 5; i++) {
            thread1s[i] = new Thread1(a);
            thread1s[i].start();
            thread2s[i] = new Thread2(a);
            thread2s[i].start();
            thread3s[i] = new Thread3(a);
            thread3s[i].start();
        }

    }

    static class Thread1 extends Thread {

        AlternatePrint a;

        public Thread1(AlternatePrint a) {
            this.a = a;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                a.printFirst();
            }
        }
    }

    static class Thread2 extends Thread {

        AlternatePrint a;

        public Thread2(AlternatePrint a) {
            this.a = a;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                a.printSecond();
            }
        }
    }

    static class Thread3 extends Thread {

        AlternatePrint a;

        public Thread3(AlternatePrint a) {
            this.a = a;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                a.printThree();
            }
        }
    }
}
