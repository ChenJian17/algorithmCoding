package concurrency;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/30 16:32
 */
public class ShareTicket {


    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i<10; i++){
                share.incr();
            }

        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i<10; i++){
                share.dec();
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i<10; i++){
                share.dec();
            }
        },"CC").start();

        new Thread(() -> {
            for (int i = 0; i<10; i++){
                share.dec();
            }
        },"DD").start();
    }


}

class Share {
    private int num = 1;

    public synchronized void incr()  {
        try {
            if (num != 0){
                // wait会释放锁让其他线程可以抢占
                //在哪里睡就会在哪里醒 -- 虚假唤醒
                wait();
            }
            num ++;
            System.out.println(Thread.currentThread().getName() + ": "+num);
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized void dec(){
        try {
            if (num != 1){
                wait();
            }
            num --;
            System.out.println(Thread.currentThread().getName() + ": "+num);
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
