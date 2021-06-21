package com.chenjian.cn.pointOffer;//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 339 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                //k表示words下标从0开始
                if (backtracking(board,words,visited,i,j,0))
                    return true;
            }
        }
        return false;

    }
    public boolean backtracking(char[][] board,char[] words,boolean[][] visited,int i, int j, int k){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || words[k]!=board[i][j] || visited[i][j] == true)
            return false;
        if (k == words.length-1)
            return true;

        visited[i][j] = true;

        boolean ans = backtracking(board,words,visited,i+1,j,k+1) ||
                backtracking(board,words,visited,i-1,j,k+1) ||
                backtracking(board,words,visited,i,j+1,k+1) ||
                backtracking(board,words,visited,i,j-1,k+1);

        visited[i][j] = false;
        return ans;

    }

    public boolean DFS(char[][] board,char[] words,int i, int j, int k){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || words[k]!=board[i][j])
            return false;
        if (k == words.length-1)
            return true;
        board[i][j] = '\0';
        boolean ans = DFS(board,words,i+1,j,k+1) ||
                DFS(board,words,i-1,j,k+1) ||
                DFS(board,words,i,j+1,k+1) ||
                DFS(board,words,i,j-1,k+1);
        board[i][j] = words[k];
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
