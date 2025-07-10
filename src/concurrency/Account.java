package concurrency;


public class Account {

    private int balance;
    public Account() {
    }
    // 转账
    void transfer(Account target, int amt){
        // 此处检查所有对象共享的锁
        synchronized(Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }

//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {

        Account a = new Account();
        Account b = new Account();

        // 初始化账户余额
        a.balance = 200;
        b.balance = 200;

        // 线程1：a 转 b
        Thread t1 = new Thread(() -> {
                System.out.println("线程1: 准备从 a 转 100 到 b");
            a.transfer(b, 100);
            System.out.println("线程1: 转账完成");
        });

        // 线程2：b 转 a
        Thread t2 = new Thread(() -> {
                System.out.println("线程2: 准备从 b 转 50 到 a");
            b.transfer(a, 50);
            System.out.println("线程2: 转账完成");
       });

        // 启动线程
        t1.start();
        t2.start();

        // 等待线程结束（实际会因死锁无法结束）
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
