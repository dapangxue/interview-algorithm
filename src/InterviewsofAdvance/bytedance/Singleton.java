package InterviewsofAdvance.bytedance;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/22 0022
 */
public class Singleton {

    /*
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
        return singleton;
    }

    private Singleton() {

    }
     */

    /*
    懒汉式 线程安全
     */
    /*
    private static Singleton instance;
    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
     */

    /*
    饿汉式 线程安全
     */
    /*
    private Singleton() {

    }

    private static Singleton singleton = new Singleton();
    public static Singleton getInstance() {
        return singleton;
    }

     */

    private volatile static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
