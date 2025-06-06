package multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/3 18:51
 */
public class CyclicBarrierDemo {

    public static int NUMBER = 7;
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,() -> {
            System.out.println("*******齐集七颗龙珠召唤神龙");
        });

        for (int i = 1; i<=NUMBER; i++){
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+" 星龙被收集到了");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
