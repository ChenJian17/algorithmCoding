package multiThread;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/28 18:01
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){
    }

    public static Singleton getSingleton(){
        if (singleton != null){
            return singleton;
        }
        synchronized (Singleton.class){
            if (singleton == null){
                singleton = new Singleton();
            }
            return singleton;
        }
    }
}
