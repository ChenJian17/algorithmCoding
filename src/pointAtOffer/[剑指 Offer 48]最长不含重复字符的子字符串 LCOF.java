package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 哈希表 字符串 滑动窗口 
// 👍 561 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution48 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = s.charAt(1) == s.charAt(0) ? 1 : 2;
        int res = Math.max(dp[0],dp[1]);
        for (int i = 2; i<s.length(); i++) {
            String str = s.substring(i-dp[i-1],i);
            if (str.contains(String.valueOf(s.charAt(i)))) {
                int index = str.indexOf(s.charAt(i));
                dp[i] = str.length()-index;
            }else {
                dp[i] = dp[i-1]+1;
            }
            res = Math.max(dp[i], res);
        }
        return res;

    }

    public static void main(String[] args) {
        String tmp = "dvdf";
        lengthOfLongestSubstring(tmp);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
