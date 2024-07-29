package layOffDays.TopKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/24 22:10
 */
public class TopKElements {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i<k; i++){
            queue.add(nums[i]);
        }
        for (int j = k; j < nums.length; j++) {
            Integer peek = queue.peek();
            if (nums[j] > peek){
                queue.poll();
                queue.offer(nums[j]);
            }
        }
        return queue.peek();
    }
}
