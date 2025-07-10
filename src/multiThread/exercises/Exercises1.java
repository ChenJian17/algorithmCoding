package multiThread.exercises;

/**
 *
 */
public class Exercises1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Hello, World!");
            System.out.println(Thread.currentThread().getPriority());
            System.out.println(Thread.currentThread().getName());
        });
        t1.start();
    }
}
