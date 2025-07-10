package multiThread.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 使用读写锁实现缓存
 * @author: sherlockchen
 * @date: 2025/6/26 21:56
 */
public class Cache<K,V> {
    final Map<K,V> map = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // write lock
    final Lock w = rwl.writeLock();

    // read cache
    V get(K key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    // write cache
    V put(K key, V value){
        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }


}
