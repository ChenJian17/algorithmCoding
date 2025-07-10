package multiThread;

import java.util.ArrayList;
import java.util.List;

class Allocator {
    private List<Object> als =
            new ArrayList<>();
    // 一次性申请所有资源
//     ①
    synchronized boolean apply(
            Object from, Object to){
        if (als.contains(from) ||
                als.contains(to)){
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }
    // 归还资源
    synchronized void free(
            Object from, Object to){
        als.remove(from);
        als.remove(to);
    }

    // ②
//    synchronized void apply(Object from, Object to){
//
//        while (als.contains(from) ||
//                als.contains(to)){
//            try {
//                wait();
//            } catch (Exception e){
//
//            }
//        }
//        als.add(from);
//        als.add(to);
//    }
//
//    // 归还资源
//    synchronized void free(
//            Object from, Object to){
//        als.remove(from);
//        als.remove(to);
//        notifyAll();
//    }

}
public class Account {

    private final Allocator actr = new Allocator();

    private int id;
    private int balance;

    // 破坏占用且等待条件
    void transfer(Account target, int amt){

        // 一次性申请转出账户和转入账户，直到成功
        while (!actr.apply(this,target)){
            try {
                // 锁定转出账户
                synchronized (this){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    // 锁定转入账户
                    synchronized (target){
                        if (this.balance > amt){
                            this.balance -= amt;
                            target.balance += amt;
                        }
                    }
                }
            }finally {
                actr.free(this, target);
            }
        }

    }

    // 按顺序申请破坏循环等待条件
//    void transfer(Account target, int amt){
//        Account left = this;
//        Account right = target;
//        if (this.id > target.id) {
//            left = target;
//            right = this;
//        }
//        // 锁定序号小的账户
//        synchronized(left){
//            // 锁定序号大的账户
//            synchronized(right){
//                if (this.balance > amt){
//                    this.balance -= amt;
//                    target.balance += amt;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account();

        a.balance = 200;
        b.balance = 200;

        Thread t1 = new Thread(() -> {
            System.out.println("线程1: 准备从 a 转 100 到 b");
            a.transfer(b,100);
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
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("a 的余额: " + a.balance);
        System.out.println("b 的余额: " + b.balance);

    }
}


