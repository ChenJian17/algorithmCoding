package com.chenjian.cn.pointOffer;//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 302 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        DFS(m, n, k,0,0,visited);

        int ans = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (visited[i][j])
                    ans ++;
            }
        }
        return ans;

    }

    public void DFS(int m, int n, int k,int start1, int start2, boolean[][] visited){
        if (start1<0 || start1>=m || start2<0 || start2>=n || sum(start1)+sum(start2)>k || visited[start1][start2])
            return;

        visited[start1][start2] = true;
        DFS(m, n, k,start1+1,start2,visited);
        DFS(m, n, k,start1-1,start2,visited);
        DFS(m, n, k,start1,start2+1,visited);
        DFS(m, n, k,start1,start2-1,visited);

    }

    public int sum(int number){
        String num = Integer.toString(number);
        int res = 0;
        for (int i=0; i<num.length(); i++){
            res += num.charAt(i)-'0';
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
