package top100.twodDp;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/16 16:38
 */
public class MinimumPathSum {

    int res = Integer.MAX_VALUE;
    int[][] memo;
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        DFS(grid,0,0,0);
         return res;

    }

    public void DFS(int[][] grid, int sum, int i, int j){
        if(i >= grid.length || j >= grid[0].length){
            return;
        }

        if(i == grid.length-1 && j == grid[0].length-1){
            sum += grid[i][j];
            res = Math.min(res, sum);
            return;
        }

        sum += grid[i][j];
        DFS(grid,sum,i+1,j);
        DFS(grid,sum,i,j+1);
    }

    public int minPathSum1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j]
        dp[0][0] = grid[0][0];
        for(int i=1;i<dp.length; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for(int j = 1; j<dp[0].length; j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length];
    }



    // 错误解法：能够递归解决，却无法记忆化，因为sum表示从起点到当前点 (i,j) 的路径和，所以子问题不是相互独立
//    int[][] memo;
//
//    public int minPathSum(int[][] grid) {
//        memo = new int[grid.length][grid[0].length];
//        for(int[] arr: memo){
//            Arrays.fill(arr,-1);
//        }
//        return DFS(grid,0,0,0);
//
//
//    }
//
//    public int DFS(int[][] grid, int sum, int i, int j){
//        if(i >= grid.length || j >= grid[0].length){
//            return Integer.MAX_VALUE;
//        }
//
//        if(i == grid.length-1 && j == grid[0].length-1){
//            sum += grid[i][j];
//            return sum;
//        }
//
//        if(memo[i][j] != -1){
//            return memo[i][j];
//        }
//
//        int ans = Math.min(DFS(grid,sum+grid[i][j],i+1,j),DFS(grid,sum+grid[i][j],i,j+1));
//        memo[i][j] = ans;
//        return ans;
//
//    }

    // 正确解法
//    int[][] memo;
//    public int minPathSum(int[][] grid) {
//        memo = new int[grid.length][grid[0].length];
//        for(int[] num: memo){
//            Arrays.fill(num,-1);
//        }
//        return DFS(grid,0,0);
//
//
//    }
//
//    public int DFS(int[][] grid,int i,int j){
//        if(i >= grid.length || j >= grid[0].length){
//            return Integer.MAX_VALUE;
//        }
//        if(i == grid.length-1 && j == grid[0].length-1){
//            return grid[i][j];
//        }
//        if(memo[i][j] != -1){
//            return memo[i][j];
//        }
//        int right = DFS(grid,i+1,j);
//        int down = DFS(grid,i,j+1);
//        int res = Math.min(right,down)+grid[i][j];
//        memo[i][j] = res;
//        return res;
//    }
}
