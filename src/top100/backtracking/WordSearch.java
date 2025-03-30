package top100.backtracking;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/26 21:34
 */
public class WordSearch {

    boolean[][] flag;

    public boolean exist(char[][] board, String word) {
        flag = new boolean[board.length][board[0].length];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (DFS(board,i,j,word,0))
                        return true;
                }
//                flag = new boolean[board.length][board[0].length];
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, int x, int y, String word, int index){
        if (index == word.length())
            return true;
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0
                || flag[x][y]){
            return false;
        }

        if (board[x][y] == word.charAt(index)){

            flag[x][y] = true;
            boolean res = DFS(board,x+1,y,word,index+1)
                    ||DFS(board,x-1,y,word,index+1)
                    ||DFS(board,x,y+1,word,index+1)
                    ||DFS(board,x,y-1,word,index+1);
            flag[x][y] = false;
            return res;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}