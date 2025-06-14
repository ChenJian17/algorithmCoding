package top100.dynamicProgramming;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/7 17:58
 */
public class PartitionSum {

    int total = 0;
    int[][] memo;
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % 2 != 0)
            return false;

        total = sum;

        memo = new int[nums.length][total/2+1];
        for (int i = 0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        return DFS(nums,0,total/2);
    }

    public boolean DFS(int[] nums, int start, int sum){
        if (sum == 0){
            return true;
        }
        if (sum < 0 || start >= nums.length-1)
            return false;

        if (memo[start][sum] != -1){
            return memo[start][sum] == 1;
        }

        boolean res = DFS(nums,start+1,sum-nums[start])
        || DFS(nums,start+1,sum);

        memo[start][sum] = res ? 1 : 0;

        return res;

    }

    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum %2 != 0)
            return false;
        int target = sum/2;

        boolean[][] dp = new boolean[len][target+1];

        for (int i = 1; i<len; i++){
            for (int j = 0; j<=target; j++){
                dp[i][j] = dp[i-1][j];
                if (j == nums[i]){
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }

            }
        }
        return dp[len-1][target];


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,11,5};
        PartitionSum ob = new PartitionSum();
        ob.canPartition(arr);
    }
}
