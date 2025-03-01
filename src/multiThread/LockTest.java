package multiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/2/9 15:25
 */
public class LockTest {

    public static void main(String[] args) {
        Lock mutex = new Lock();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                doLockTest(mutex);
            }, "Thread-" + i).start();
        }
    }


    static void doLockTest(Lock mutex){
        mutex.lock(); // 加锁
        try {
            // 临界区代码
            System.out.println(Thread.currentThread().getName() + " has acquired the lock.");
            // 模拟一些工作
//          Thread.sleep(1000); // 此处可以模拟工作，实际空转时可以去掉
        }  finally {
            mutex.unlock(); // 解锁
            System.out.println(Thread.currentThread().getName() + " has released the lock.");
        }
    }

}
