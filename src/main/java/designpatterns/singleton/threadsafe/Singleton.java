package designpatterns.singleton.threadsafe;

/**
 * synchronized는 불필요한 오버헤드를 증가시킬 수 있다.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }
}
