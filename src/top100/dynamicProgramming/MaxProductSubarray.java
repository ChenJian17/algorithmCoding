package top100.dynamicProgramming;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/7 17:22
 */
public class MaxProductSubarray {

    public int maxProduct(int[] nums) {

        int len = nums.length;

        int[][] dp = new int[len][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for(int i = 1; i<len; i++){
            if(nums[i] >= 0){
                dp[i][1] = Math.max(dp[i-1][1]*nums[i],nums[i]);
                dp[i][0] = Math.min(dp[i-1][0]*nums[i],nums[i]);
            }else{
                dp[i][0] = Math.min(dp[i-1][1]*nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i-1][0]*nums[i],nums[i]);
            }
        }

        int res = dp[0][1];
        for(int i = 1; i<len; i++){
            res = Math.max(dp[i][1],res);
        }

        return res;
    }
}
