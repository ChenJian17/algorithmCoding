package layOffDays.SlidingWindow;

import java.util.ArrayList;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays
 * @Author: Joker
 * @CreateTime: 2023-02-28 21:46
 * @Description:
 */
public class MaximumSumSubarrayofSizeK {

//    public long maximumSumSubarray(int K, int[] nums) {
//        // code here
//        int res = Integer.MIN_VALUE, left = 0, right = K - 1, sum = 0;
//        for (int i = 0; i < K; i++) {
//            sum += nums[i];
//        }
//        while (right < nums.length) {
//            res = Math.max(res, sum);
//            sum -= nums[left++];
//            sum += nums[right++];
//        }
//        return sum;
//
//    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int left = 0, right = K-1;
        long res = Integer.MIN_VALUE,sum = 0;
        for (int i = 0; i< K; i++){
            sum += Arr.get(i);
        }
        res = Math.max(res, sum);
        while (right < Arr.size()-1){
            sum -= Arr.get(left++);
            sum += Arr.get(++right);
            res = Math.max(res, sum);
        }
        return res;
    }
}
