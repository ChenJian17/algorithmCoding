package multiThread.exercises;

/**
 * Write a Java program that creates two threads to find and print even and odd numbers from 1 to 20.
 */
public class Exercises2 {

    volatile static boolean flag = false;

    private static final int MAX_NUMBER = 20;

    public static void main(String[] args) {

        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i<=MAX_NUMBER; i+=2){
                synchronized (lock){
                    while (flag){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    System.out.println(i+" thread: "+Thread.currentThread().getName());
                    System.out.println("A"+" thread: "+Thread.currentThread().getName());
                    flag = true;
                    lock.notify();
                }

            }

        },"t1");

        Thread t2 = new Thread(() -> {
            for (int i = 2; i<=MAX_NUMBER; i +=2){
                synchronized (lock){
                    while (!flag){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    System.out.println(i+" thread: "+Thread.currentThread().getName());
                    System.out.println("B"+" thread: "+Thread.currentThread().getName());
                    flag = false;
                    lock.notify();
                }

            }

        },"t2");

        t1.start();
        t2.start();

    }
}
