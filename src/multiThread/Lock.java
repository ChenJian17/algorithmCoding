package multiThread;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/9 15:21
 */
public class Lock {
    private int flag;

    public Lock() {
        this.flag = 0; // 锁可用
    }

    public void lock() {
        while (flag == 1){
            // spin-wait (do nothing)
            System.out.println(Thread.currentThread().getName());
        }
        flag =1;
    }


    public void unlock() {
        // 释放锁
        flag = 0; // 设置锁为可用
    }


}
