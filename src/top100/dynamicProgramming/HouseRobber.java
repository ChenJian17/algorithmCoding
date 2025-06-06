package top100.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/8 20:34
 */
public class HouseRobber {

    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k<nums.length; k++){
            dp[k] = Math.max(dp[k-1],nums[k]+dp[k-2]);
        }

        return dp[nums.length-1];


    }

//    Map<Integer,Integer> map = new HashMap<>();
    public int DFS(int[] nums, int index, int res){
        if (index >= nums.length){
            return res;
        }
//        if (map.containsKey(index)){
//            return map.get(index);
//        }

        if (index >= 0){
            res += nums[index];
        }


        int left = DFS(nums,index+2, res);
        int right = DFS(nums,index+3, res);

//        map.put(index,Math.max(left,right));
        return Math.max(left,right);
    }
}
