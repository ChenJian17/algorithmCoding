package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 回溯 矩阵 
// 👍 768 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution12 {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i<board.length; i++)
            for (int j = 0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (helper(board,i,j,word,0,new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        return false;

    }
    public static boolean helper(char[][] board, int i, int j, String word, int index,boolean[][] flag){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length){
            return false;
        }
        if (j < 0 || j >= board[0].length){
            return false;
        }

        if (board[i][j] == word.charAt(index) && !flag[i][j]){
            flag[i][j] = true;
            boolean res = helper(board,i-1,j,word,index+1,flag)
            || helper(board,i+1,j,word,index+1,flag)
            || helper(board,i,j-1,word,index+1,flag)
            || helper(board,i,j+1,word,index+1,flag);
            flag[i][j] = false;
            return res;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        exist(board,"ABCESEEEFS");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
