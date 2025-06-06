package top100.dynamicProgramming;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/19 22:17
 */
public class ThreeStepsProblem {

//    Map<Long,Long> map = new HashMap<>();
//    public int waysToStep(int n) {
//        return (int) DFS(n)%1000000007;
//    }
//
//    public long DFS(long n){
//
//        if (n == 1){
//            return 1;
//        }
//        if (n == 2){
//            return 2;
//        }
//        if (n == 3){
//            return 4;
//        }
//        if (map.containsKey(n))
//            return map.get(n);
//        long res = DFS(n-1)+DFS(n-2)+DFS(n-3);
//        map.put(n,res);
//        return res;
//
//    }

    public int waysToStep(int n) {

        if(n <= 2)
            return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i<n; i++){
            dp[i] = (dp[i-1]+(dp[i-2]+dp[i-3])%1000000007)%1000000007;
        }
        return dp[n];
    }
}
