package top100.dynamicProgramming;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/25 16:25
 */
public class EditDistance {

//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        int[][] dp = new int[m+1][n+1];
//        for(int j = 0; j<=n; j++){
//            dp[0][j] = j;
//        }
//        for(int i = 0; i<=m; i++){
//            dp[i][0] = i;
//        }
//        //减 - dp[i-1][j]，增 - dp[i][j-1], 改 - dp[i-1][j-1]
//        for(int i =1; i<=m; i++){
//            for(int j = 1; j<=n; j++){
//                if(word1.charAt(i-1) == word2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1];
//                }else{
//                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
//                }
//            }
//        }
//        return dp[m][n];
//    }


    int[][] memo;
    char[] s1,s2;

    public int minDistance(String word1, String word2){
        s1 = word1.toCharArray();
        s2 = word2.toCharArray();
        int m = s1.length, n = s2.length;
        memo = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(memo[i],-1);
        }
//        for (int[] row : memo){
//            Arrays.fill(row,-1);
//        }
        return DFS(m-1,n-1);

    }

    public int DFS(int i, int j){
        if (i == -1)
            return j+1;
        if (j == -1)
            return i+1;

        if (memo[i][j] != -1){
            return memo[i][j];
        }

        if (s1[i] == s2[j]){

            return memo[i][j] = DFS(i-1,j-1);
        }
        return memo[i][j] = Math.min(DFS(i-1,j),Math.min(DFS(i,j-1),DFS(i-1,j-1)))+1;
    }

}
