package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 记忆化搜索 数学 动态规划 
// 👍 459 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution10I {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i =2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
            dp[i] = dp[i]%1000000008;
        }
        return dp[n];


    }
}
//leetcode submit region end(Prohibit modification and deletion)
