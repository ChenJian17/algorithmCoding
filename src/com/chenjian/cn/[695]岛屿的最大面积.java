package com.chenjian.cn;//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 455 👎 0


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution695 {
    private final static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];//记录是否呗访问过
        for (int i = 0; i<row; i++){
            for (int j = 0; j<column; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    max = Math.max(max, findarea(i, j, row, column, visited, direction,grid));
                }

            }
        }
        return max;

    }

    public static int findarea(int i, int j, int row, int column, boolean[][] visited, int[][] direction,int[][] grid){

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int count = 1;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int[] temp: direction){
                int NewX = curX+temp[0];
                int NewY = curY+temp[1];
                if(judge(NewX,NewY,row,column) && !visited[NewX][NewY] && grid[NewX][NewY] == 1){
                    count++;
                    queue.offer(new int[]{NewX,NewY});
                    visited[NewX][NewY] = true;
                }

            }
        }

       return count;

    }

    public static boolean judge(int i, int j, int row, int column){
        return i>=0&&i<row&&j>=0&&j<column;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
