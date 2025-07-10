package layOffDays;


import java.util.ArrayList;
import java.util.List;

class Allocator {
    private List < Object > als = new ArrayList < > ();
    synchronized void apply(Object from, Object to) throws InterruptedException {
        // 等待直到两个资源都可用
        while (als.contains(from) || als.contains(to)) {
            wait();
        }
        als.add(from);
        als.add(to);
    }
    // 归还资源
    synchronized void free(
            Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll(); // 唤醒所有等待的线程
    }
}
public class Account {
    private final Allocator actr = new Allocator();
    private int balance;
    void transfer(Account target, int amt) {
        // 一次性申请转出账户和转入账户，直到成功
        try {
            // 申请资源（锁定账户）
            actr.apply(this, target);
            // 执行转账操作
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 释放资源（解锁账户）
            actr.free(this, target);
        }

    }
    public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account();
        a.balance = 200;
        b.balance = 200;

        Thread t1 = new Thread(() -> {
            System.out.println("线程1: 准备从 a 转 100 到 b");
            a.transfer(b, 100);
            System.out.println("线程1: 转账完成");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("线程2: 准备从 b 转 50 到 a");
            b.transfer(a, 50);
            System.out.println("线程2: 转账完成");
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a 的余额: " + a.balance);
        System.out.println("b 的余额: " + b.balance);
    }
}