package dataDance;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/11 21:07
 */
public class LeetCode200 {

    public int numIslands(char[][] grid){
        int count = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0;j<grid[0].length; j++){
                if (grid[i][j] == '1'){
                    count++;
                    DFS(grid,i,j);
                }
            }
        }
        return count;

    }

    public void DFS(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if (grid[i][j] == '0')
            return;
        if (grid[i][j] == '1'){
            grid[i][j] = '2';
        }
        DFS(grid,i+1,j);
        DFS(grid,i,j+1);
        DFS(grid,i-1,j);
        DFS(grid,i,j-1);
    }
}
