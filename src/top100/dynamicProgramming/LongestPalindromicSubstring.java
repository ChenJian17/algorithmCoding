package top100.dynamicProgramming;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/21 16:58
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        int len = s.length();
        int start = 0, maxLen = 1;

        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i<len; i++)
            dp[i][i] = true;

        char[] arr = s.toCharArray();
        for(int j =1; j<len; j++){
            for(int i = 0; i<j; i++){
                if(arr[i] != arr[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }


                    if(dp[i][j] && (j-i+1 > maxLen)){
                        start = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }

        return s.substring(start,start+maxLen);

    }
}
