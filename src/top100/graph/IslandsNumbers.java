package top100.graph;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/6 20:57
 */
public class IslandsNumbers {


    public int numIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == '1'){
                    DFS(grid,i,j);
                    count++;
                }

            }
        }
        return count;

    }

    private void DFS(char[][] grid, int i, int j){
        if (!area(grid,i,j))
            return;
        if (grid[i][j] != '1')
            return;
        grid[i][j] = '2';

        DFS(grid,i+1,j);
        DFS(grid,i,j+1);
        DFS(grid,i-1,j);
        DFS(grid,i,j-1);
    }

    private boolean area(char[][] grid, int i, int j){
        return i >= 0 && i < grid.length
                && j >= 0 && j < grid[0].length;
    }


}
