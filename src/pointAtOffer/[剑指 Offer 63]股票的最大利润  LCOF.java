package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 动态规划 
// 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices == null)
            return 0;
        int[] dp = new int[prices.length+1];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++){
            min = Math.min(prices[i],min);
            dp[i] = Math.max(dp[i-1], prices[i]-min);
        }
        return dp[prices.length-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
