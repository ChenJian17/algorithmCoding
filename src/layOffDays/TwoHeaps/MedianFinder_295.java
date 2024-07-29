package layOffDays.TwoHeaps;

import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/6/16 10:44
 */
public class MedianFinder_295 {

    //小根堆，堆顶元素最小
    private PriorityQueue<Integer> minHeap ;
    //大根堆，堆顶元素最大
    private PriorityQueue<Integer> maxHeap ;

    public MedianFinder_295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x,y) -> y-x);
    }

    public void addNum(int num) {
        if(minHeap.size() == maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
