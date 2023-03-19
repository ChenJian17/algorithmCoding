package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 分治 动态规划 
// 👍 672 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i<nums.length; i++){
            if (dp[i-1] > 0){
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
