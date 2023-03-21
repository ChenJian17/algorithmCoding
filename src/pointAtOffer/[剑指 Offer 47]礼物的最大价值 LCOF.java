package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 动态规划 矩阵 
// 👍 475 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++) {
                if (i == 0 && j == 0){
                    grid[i][j] = grid[0][0];
                }else if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                }else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                }else {
                    grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
                }
            }
        return grid[m-1][n-1];


    }
}
//leetcode submit region end(Prohibit modification and deletion)
