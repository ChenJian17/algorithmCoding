package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 字符串 动态规划 
// 👍 547 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution45 {
    public static int translateNum(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() == 1)
            return 1;
        if (numStr.length() == 2){
            return num <26 && num > 9 ? 2 : 1;
        }
        int [] dp = new int[numStr.length()];
        dp[0] = 1;
        String str = numStr.substring(0,2);
        int tmp = Integer.valueOf(str);
        dp[1] = tmp <26 && tmp > 9 ? 2 : 1;

        for (int i = 2; i< numStr.length(); i++) {
            String str1 = numStr.substring(i-1,i+1);
            int tmp1 = Integer.valueOf(str1);
            dp[i] = tmp1 <26 && tmp1 > 9 ? dp[i-1]+dp[i-2] :dp[i-1];
        }
        return dp[numStr.length()-1];

    }

    public static void main(String[] args) {
        translateNum(220);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
