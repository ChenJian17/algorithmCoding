package top100.graph;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/6 23:54
 */
public class IslandPerimeter {
    int res = 0;
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    DFS(grid, i, j);
                }
            }
        }
        return res;
    }

    public void DFS(int[][] grid, int i, int j){
        if (!exist(grid, i, j)){
            res++;
            return;
        }
        if (grid[i][j] == 0){
            res++;
            return;
        }
        if (grid[i][j] == 2){
            return;
        }
        grid[i][j] = 2;
        DFS(grid, i+1, j);
        DFS(grid, i, j+1);
        DFS(grid, i-1, j);
        DFS(grid, i, j-1);

    }

    public boolean exist(int[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
