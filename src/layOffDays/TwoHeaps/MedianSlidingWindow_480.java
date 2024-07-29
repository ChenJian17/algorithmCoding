package layOffDays.TwoHeaps;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/6/16 17:14
 */
public class MedianSlidingWindow_480 {

//    public double[] medianSlidingWindow(int[] nums, int k) {
//
//        //小顶堆，存放较大数
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        //大顶堆，存放较小数
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
//
//        double[] res = new
//        for (int i = 0; i<k; i++) {
//            if (minHeap.size() == maxHeap.size()) {
//                minHeap.add(nums[i]);
//                maxHeap.add(minHeap.poll());
//            }else {
//                maxHeap.add(nums[i]);
//                minHeap.add(maxHeap.poll());
//            }
//        }
//
//
//        for (int i = k; i<nums.length; i++) {
//            if (minHeap.contains(nums[i-k])) {
//                minHeap.remove(nums[i-k]);
//                maxHeap.add(nums[i]);
//                minHeap.add(maxHeap.poll());
//            }else {
//                maxHeap.remove(nums[i-k]);
//                minHeap.add(nums[i]);
//                maxHeap.add(minHeap.poll());
//            }
//            list.add(getMedianNum(minHeap,maxHeap));
//        }
//
//        return res;
//
//    }
//
//    //约定大顶堆+1
//    public double getMedianNum(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
//        if (minHeap.size() == maxHeap.size()) {
//            return minHeap.peek()/2.0+maxHeap.peek()/2.0;
//        }else {
//            return maxHeap.peek();
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
//        MedianSlidingWindow_480 object = new MedianSlidingWindow_480();
//        object.medianSlidingWindow(nums,2);
//    }
}
