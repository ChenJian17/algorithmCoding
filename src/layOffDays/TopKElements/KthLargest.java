package layOffDays.TopKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/27 11:42
 */
public class KthLargest {

    // 小顶堆
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num: nums){
            if (queue.size()<k){
                queue.offer(num);
            }else if (queue.peek() < num){
                queue.poll();
                queue.offer(num);
            }
        }
    }

    public int add(int val) {
        if (queue.size() >= k){
            if (val > queue.peek()){
                queue.poll();
                queue.offer(val);
            }
        }else {
            queue.offer(val);
        }

        return queue.peek();
    }

}
