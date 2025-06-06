package multiThread;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    // 放数据
    public void put(String key,Object value){

        try {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+" 正在写操作"+key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写完了"+key);
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }

    //取数据
    public Object get(String key){

        Object value = null;
        try {
            rwLock.readLock().lock();

            System.out.println(Thread.currentThread().getName()+" 正在读操作"+key);
            TimeUnit.MICROSECONDS.sleep(300);
            value =  map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读完了"+key);
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            //释放读锁
            rwLock.readLock().unlock();
        }

        return value;
    }
}
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache cache = new MyCache();
        // 创建线程写数据
        for (int i = 1; i<=5; i++){
            final int num = i;
            new Thread(()-> {
                cache.put(num+"", num+"");
            },String.valueOf(i)).start();
        }

        // 创建线程读数据
        for (int i = 1; i<=5; i++){
            final int num = i;
            new Thread(()-> {
                cache.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}
