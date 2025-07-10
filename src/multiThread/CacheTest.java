package multiThread;

import com.chenjian.java.Test;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/17 16:50
 */
public class CacheTest {

    private static  long count = 0;
    private void add10K(){
        synchronized (CacheTest.class){
            int idx = 0;
            while (idx++ < 10000){
                count += 1;
            }
        }

    }

    public static long cal() throws InterruptedException {
        final CacheTest test = new CacheTest();
        Thread t1 = new Thread(test::add10K);

        Thread t2 = new Thread(test::add10K);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        return count;

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(CacheTest.cal());
    }

}
