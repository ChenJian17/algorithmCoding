package dataDance;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/11 21:49
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i<len; i++){
            for (int j = 0; j<i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i =0; i<len; i++){
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
