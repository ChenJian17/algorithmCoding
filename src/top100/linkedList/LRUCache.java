package top100.linkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/10/5 09:56
 */
public class LRUCache {
    private class Node {
        int key, val;
        Node pre, next;
        private Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList {
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        int size;

        private DoubleList(){
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        private void addFirst(Node node){
            Node headNext = head.next;
            head.next = node;
            headNext.pre = node;
            node.pre = head;
            node.next = headNext;
            size++;
        }

        private void remove(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        private Node removeLast(){
            Node last = tail.pre;
            remove(last);
            return last;
        }

        private int size(){
            return size;
        }
    }


    // 哈希表：key -> Node(key,val)
    private Map<Integer, Node> map;

    // 双向链表：node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;

    private int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        cache.remove(map.get(key));
        cache.addFirst(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value){
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key,node);

        }else {
            map.put(key,node);
            cache.addFirst(node);
            if (cache.size() >= capacity){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);

        lruCache.get(2);

        lruCache.put(1,1);
        lruCache.put(4,1);

        lruCache.get(2);

    }
}
