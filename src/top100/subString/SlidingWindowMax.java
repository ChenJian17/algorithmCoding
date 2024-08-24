package top100.subString;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/20 21:38
 */
public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();

        int[] res = new int[nums.length-k+1];
        for (int i = 0; i<nums.length; i++){

            // 1. 入
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]){
                queue.pollLast();
            }
            queue.addLast(i);

            // 2. 出
            if (queue.getFirst() <= (i-k)) {
                queue.removeFirst();
            }

            // 3. 采集结果
            if ((i-k+1) >= 0){
                res[i-k+1] = nums[queue.getFirst()];
            }

        }
        return res;


    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3,-1,-3,5,3,6,7};
        for (int x: maxSlidingWindow(num,3)){
            System.out.println(x);
        }
    }
}
