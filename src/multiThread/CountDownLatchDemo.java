package multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * 减少计数
 */
public class CountDownLatchDemo {

    // 6个同学陆续离开教室，班长锁门

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(6);

        for (int i = 0; i<6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+" 号同学离开教室");
                downLatch.countDown();
            },String.valueOf(i)).start();
        }

        downLatch.await();

        System.out.println(Thread.currentThread().getName()+" 班长锁门走人了");

    }
}
