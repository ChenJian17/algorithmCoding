package top100.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/27 22:52
 */
public class PerfectSquares {

    public int numSquares2(int n) {
        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j<=n; j++){
                dp[i][j] = n+1;
            }
        }
        // 初始化，方便后续的递推
        dp[0][0] = 0;
        int count = 0;
        for (int i =1; i*i <= n; i++){
            count = i;
            for (int j = 0; j<=n;j++){
                if (i*i > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-i*i]+1);
                }
            }
        }
        return dp[count][n];
    }

    public int numSquares1(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        for (int i = 1; i*i <= n; i++){
            dp[i] = i;
            for (int j = 1; j<= n; j++){
                if (i*i > j ){
                    dp[i] = dp[i-1];
                }else {
                    dp[i] = Math.min(dp[i-1],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
    public int numSquares(int n) {
        // 预处理出 <=sqrt(n) 的完全平方数
        List<Integer> nums = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            nums.add(i * i);
            i++;
        }

        // 转化为完全背包问题【套用「322. 零钱兑换」】
        int target = n;
        int length = nums.size();
        int[][] dp = new int[length + 1][target + 1];


        // 初始化为一个较大的值，如 target+1
        for (int[] row : dp) {
            Arrays.fill(row, target + 1);
        }

        dp[0][0] = 0; // 合法的初始化；其他 dp[0][j]均不合法

        // 完全背包：优化后的状态转移
        for (i = 1; i <= length; i++) { // 第一层循环：遍历nums
            for (int j = 0; j <= target; j++) { // 第二层循环：遍历背包
                if (j < nums.get(i - 1)) { // 容量有限，无法选择第i个数字
                    dp[i][j] = dp[i - 1][j];
                } else { // 可选择第i个数字
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - nums.get(i - 1)] + 1);
                }
            }
        }

        return dp[length][target];
    }

    public int numSquares3(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for (int i = 1; i<=n; i++){
            for (int j = 1; j <= n; j++){
                if (i*i > j){
                    dp[j] = dp[j];
                }else {
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }

    public int numSquares4(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for (int i = 1; i<=n; i++){
            for (int j = i*i; j<=n; j++){
                dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
