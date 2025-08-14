package multiThread;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/13 11:56
 */
public class ProducerConsumer {

    private static final int Q_SIZE = 10;
    private LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(Q_SIZE);
    private volatile boolean stop = false;

    Runnable producer = () -> {
        while (!stop){
            try {
                queue.offer(UUID.randomUUID().toString(),1, TimeUnit.SECONDS);
            }catch (InterruptedException e){

            }
        }
    };

    Runnable consumer = () -> {
        while (!stop){
            try {
                String value = queue.take();
                System.out.println(Thread.currentThread().getName()+"|"+value);
            }catch (InterruptedException e){

            }
        }
    };

    void start(){
        new Thread(producer,"Thread 1").start();
        new Thread(producer,"Thread 2").start();
        new Thread(consumer,"Thread 3").start();
        new Thread(consumer,"Thread 4").start();
    }
}
