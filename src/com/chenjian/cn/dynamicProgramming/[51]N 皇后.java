package com.chenjian.cn.dynamicProgramming;//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 790 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
// 代码看懂了，但让我写还是写不出。需要多做。
class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();//最终结果
        int[] queues = new int[n]; //放置位置的结果,需要重复使用
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<>(); //列
        Set<Integer> diagonal1 = new HashSet<>(); //主对角线
        Set<Integer> diagonal2 = new HashSet<>(); //副对角线
        backtrack(result, queues, n, 0, columns, diagonal1, diagonal2);
        return result;


    }
    public void backtrack(List<List<String>> result, int[] queues, int n, int row, Set<Integer> columns, Set<Integer> diagonal1, Set<Integer> diagonal2){
        if (row == n){
            List<String> board = geneboard(queues, n);
            result.add(board);
        }else {
            for(int i =0; i < n; i++){
                if(columns.contains(i))
                    continue;
                int diagonals1 = row - i;
                if (diagonal1.contains(diagonals1))
                    continue;
                int diagonals2 = row + i;
                if (diagonal2.contains(diagonals2))
                    continue;
                queues[row] = i;
                columns.add(i);
                diagonal1.add(diagonals1);
                diagonal2.add(diagonals2);
                backtrack(result, queues, n, row+1, columns, diagonal1, diagonal2);
                queues[row] = -1;
                columns.remove(i);
                diagonal1.remove(diagonals1);
                diagonal2.remove(diagonals2);

            }
        }
    }

    // 进行递归
    public List<String> geneboard(int[] queues, int n){
        List<String> board = new ArrayList<>();
        for(int i =0; i <n; i++){
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[queues[i]] = 'Q';
            board.add(new String(arr));
        }
        return board;
    }

    //




}
//leetcode submit region end(Prohibit modification and deletion)
