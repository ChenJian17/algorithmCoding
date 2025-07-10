package multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/27 12:41
 */
public class Reconciliation {

    Executor executor =
            Executors.newFixedThreadPool(2);

    public void reconcil() throws InterruptedException {

        while (true){
            CountDownLatch latch = new CountDownLatch(2);
            // 创建2个线程的线程池
            executor.execute(() -> {
                getDOrders();
                latch.countDown();
            });
            executor.execute(() -> {
                getPOrders();
                latch.countDown();
            });

            latch.await();


        }
    }

    public void getPOrders(){

    }

    public void getDOrders(){

    }
}
