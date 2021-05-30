package designpatterns.singleton.classic;

/**
 * 멀티 스레드 환경에서 문제 발생 가능성이 있다.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }
}
