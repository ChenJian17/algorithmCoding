package top100.dynamicProgramming;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/24 11:03
 */
public class LongestCommonSubsequence {

      // 递归搜索
//    public int longestCommonSubsequence(String text1, String text2) {
//        char[] s1 = text1.toCharArray();
//        char[] s2 = text2.toCharArray();
//        int m = s1.length;
//        int n = s2.length;
//        return DFS(s1,s2,m-1,n-1);
//
//    }
//
//    public int DFS(char[] s1,char[] s2, int m, int n){
//        if(m < 0 || n < 0)
//            return 0;
//
//        if(s1[m] == s2[n]){
//            return 1+DFS(s1,s2,m-1,n-1);
//        }
//
//        return Math.max(DFS(s1,s2,m-1,n),DFS(s1,s2,m,n-1));
//
//    }


    // 记忆化递归
//    int[][] memo;
//    public int longestCommonSubsequence(String text1, String text2) {
//        char[] s1 = text1.toCharArray();
//        char[] s2 = text2.toCharArray();
//        int m = s1.length;
//        int n = s2.length;
//        memo = new int[m][n];
//        for(int i = 0; i<m; i++){
//            Arrays.fill(memo[i],-1);
//        }
//        return DFS(s1,s2,m-1,n-1);
//    }
//
//    public int DFS(char[] s1,char[] s2, int m, int n){
//        if(m < 0 || n < 0)
//            return 0;
//        if(memo[m][n] != -1)
//            return memo[m][n];
//
//        if(s1[m] == s2[n]){
//            return memo[m][n] = 1+DFS(s1,s2,m-1,n-1);
//        }
//        int tmp =  Math.max(DFS(s1,s2,m-1,n),DFS(s1,s2,m,n-1));
//        memo[m][n] = tmp;
//        return tmp;
//    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];

    }
}
