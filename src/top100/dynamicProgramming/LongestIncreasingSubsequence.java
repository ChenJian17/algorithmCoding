package top100.dynamicProgramming;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/7 12:54
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,1);

        dp[1] = 1;

        for(int i =1; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int ans = 0;
        for(int i =0; i<dp.length; i++){
            ans = Math.max(dp[i],ans);
        }
        return ans;

    }
}
