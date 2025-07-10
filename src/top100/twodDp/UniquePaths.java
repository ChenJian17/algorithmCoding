package top100.twodDp;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/16 15:33
 */
public class UniquePaths {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] arr: memo){
            Arrays.fill(arr,-1);
        }
        return DFS(0,0,m,n);


    }

    public int DFS(int i, int j, int m, int n){
        if(i >= m || j >= n){
            return 0;
        }
        if(i==(m-1) && j == (n-1)){
            return 1;
        }
        if(memo[i][j] != -1)
            return memo[i][j];
        int num = DFS(i+1,j,m,n)+DFS(i,j+1,m,n);
        memo[i][j] = num;
        return num;

    }


    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j<n;j++){
            dp[0][j] = 1;
        }
        //dp[i][j] = dp[i-1][j]+dp[i][j-1]
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
