package top100.heap;

import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/28 12:48
 */
public class MedianFinder {

    PriorityQueue<Integer> front, after;

    public MedianFinder() {
        // 大根堆
        front = new PriorityQueue<>((a,b) -> b-a);
        // 小根堆 从小到大
        after = new PriorityQueue<>((a,b) -> a-b);

    }

    public void addNum(int num) {
        int s1 = front.size(), s2 = after.size();
        if (s1 == s2){
            if (after.isEmpty() || num <= after.peek()){
                front.offer(num);
            }else {
                front.offer(after.poll());
                after.offer(num);
            }
        }else {
            if (num >= front.peek()){
                after.offer(num);
            }else {
                after.offer(front.poll());
                front.offer(num);
            }
        }

    }

    public double findMedian() {
        int s1 = front.size(), s2 = after.size();
        if (s1 == s2){
            return (front.peek()+after.peek())/2.0;

        }else {
            return front.peek();
        }

    }
}
