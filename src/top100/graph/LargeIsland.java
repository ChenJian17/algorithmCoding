package top100.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/6 21:56
 */
public class LargeIsland {

    List<Integer> area = new ArrayList<>();
    public int largestIsland(int[][] grid) {
        int count = 2;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    int tmp = DFS(grid, i, j, count);
                    area.add(tmp);
                    count++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    int tmp = calculate(grid,i,j);
                    res = Math.max(res,tmp);
                }
            }
        }
        return res == 0 ? area.get(0) : res;

    }

    public int calculate(int[][] grid, int i, int j){
        Set<Integer> set = new HashSet<>();
        if (fun(grid,i+1,j) != 0)
            set.add(fun(grid, i+1, j));
        if (fun(grid,i,j+1) != 0)
            set.add(fun(grid,i,j+1));
        if (fun(grid,i-1,j) != 0)
            set.add(fun(grid,i-1,j));
        if (fun(grid,i,j-1) != 0)
            set.add(fun(grid,i,j-1));
        int res = 1;
        for (Integer num: set){
            res += area.get(num-2);
        }
        return res;
    }
    public int fun(int[][] grid, int i, int j){
        if (!exist(grid, i, j))
            return 0;
        else
            return grid[i][j];
    }

    public int DFS(int[][] grid, int i, int j, int count){
        if (!exist(grid,i,j))
            return 0;
        if (grid[i][j] != 1)
            return 0;
        grid[i][j] = count;

        return 1+DFS(grid,i+1,j,count)+DFS(grid,i,j+1,count)
               +DFS(grid,i-1,j,count)+DFS(grid,i,j-1,count);
    }



    public boolean exist(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length
                && j >= 0 && j < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1},{1,1}};
        LargeIsland island = new LargeIsland();
        island.largestIsland(grid);
    }
}
