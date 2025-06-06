package top100.dynamicProgramming;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/12 22:47
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 0; i<=dp.length; i++){
            for (int coin : coins){
                if (i - coin > 0)
                    continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 0; i<coins.length; i++){
            for(int j = 1; j<= amount; j++){
                if(coins[i] > j){
                    dp[j] = dp[j];
                } else{
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }

            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];

    }


    public int coinChange2(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 0; i<coins.length; i++){
            for(int j = coins[i]; j<= amount; j++){
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];


    }
}
