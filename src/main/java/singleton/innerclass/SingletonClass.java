package singleton.innerclass;

/**
 * @author：marco.pan
 * @ClassName：SingletonClass
 * @Description：
 * @date: 2026年02月07日 16:02
 */
public class SingletonClass {

    private SingletonClass() {
    }

    private static class SingletonHolder {
        private static SingletonClass instance = new SingletonClass();
    }

    public static SingletonClass getInstance() {
        return SingletonHolder.instance;
    }
}
