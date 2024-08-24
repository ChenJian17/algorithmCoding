package top100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/20 00:12
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int[] numSum = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            if (i == 0) {
                numSum[i] = nums[i];
            }else {
                numSum[i] = numSum[i-1]+nums[i];
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i<numSum.length; i++){
            if (map.containsKey(numSum[i]-k)){
                res++;
            }
            map.put(numSum[i],i);
        }
        return res;
    }

    public static int subarraySum1(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int res = 0;
        int preSum = 0;
        for (int x : nums){
            preSum += x;
            if (map.containsKey(preSum-k)){
                res += map.get(preSum-k);
            }
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,1,0};
        subarraySum1(input, 2);
    }
}
