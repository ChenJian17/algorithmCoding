package multiThread;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/15 12:33
 */

class Resource{
    volatile int num = 0;

    public synchronized void plus(){
        num ++;
    }

    public void print(){
        System.out.println(Thread.currentThread());
        System.out.println(num);
    }
}
public class AlternatePrinting {

    volatile static boolean flag = true;

    public static void main(String[] args) {
        Resource resource = new Resource();

        new Thread(() -> {

            if (flag){
                resource.plus();
                resource.print();
            }
            flag = !flag;
        },"t1").start();

        new Thread(() -> {
            if (!flag){
                resource.plus();
                resource.print();
            }
            flag = !flag;
        },"t2").start();
    }
}
