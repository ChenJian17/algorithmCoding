package top100.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/4/22 23:44
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k){
        //大根堆
        PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>(Comparator.reverseOrder());
        for (int num: nums){
            priorityQueue.add(num);
        }
        while (k > 1){
            priorityQueue.poll();
            k--;
        }
        return priorityQueue.poll();
    }

    public int findKthLargest1(int[] nums, int k){
        //小根堆
        PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>(Comparator.comparing(a->a));

        for (int i = 0; i<k; i++){
            priorityQueue.offer(nums[i]);
        }

        for (int j=k; j<nums.length; j++){
            if (nums[j] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(nums[j]);
            }
        }
        return priorityQueue.peek();


    }
}
