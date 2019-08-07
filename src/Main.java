import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.nio.channels.Pipe;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Main {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) throws Exception {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                local.set(3);
                System.out.println(local.get());
                local.set(5);
                System.out.println(local.get());
                local.remove();
                System.out.println(local.get());
            }
        });
        a.start();

        local.set(6);
        TimeUnit.SECONDS.sleep(400);
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
    }

}
