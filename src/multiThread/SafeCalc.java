package multiThread;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/18 17:14
 */
public class SafeCalc {

    long value = 0L;
    synchronized long get() {
        return value;
    }
    synchronized void addOne() {

        for (int i = 0; i<10000; i++)
            value += 1;

    }

    public static void main(String[] args) throws InterruptedException {
        SafeCalc safeCalc = new SafeCalc();
        Thread t1 = new Thread(safeCalc::addOne);
        Thread t2 = new Thread(() -> {
            System.out.println(safeCalc.get());
        });
        t1.start();
//        Thread.sleep(500);
        t2.start();

        t1.join();
        t2.join();
    }
}
