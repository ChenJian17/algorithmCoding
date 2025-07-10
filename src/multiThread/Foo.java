package multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/5 22:52
 */
public class Foo {

    volatile int count = 1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


}
