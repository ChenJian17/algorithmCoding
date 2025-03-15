package top100.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/3/8 11:20
 */
public class RottingOranges {


    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    count ++;
                }else if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int round = 0;
        while (count > 0 && !queue.isEmpty()){
            int n = queue.size();
            round ++;
            for (int i = 0; i<n; i++){
                int[] tmp = queue.poll();
                int l = tmp[0], r = tmp[1];
                if (l-1 >= 0 && grid[l-1][r] == 1){
                    grid[l-1][r] = 2;
                    count --;
                    queue.add(new int[]{l-1,r});
                }
                if (r-1 >= 0 && grid[l][r-1] == 1){
                    grid[l][r-1] = 2;
                    count --;
                    queue.add(new int[]{l,r-1});
                }
                if (l+1 < grid.length && grid[l+1][r] == 1){
                    grid[l+1][r] = 2;
                    count --;
                    queue.add(new int[]{l+1,r});
                }
                if (r+1 < grid[0].length && grid[l][r+1] == 1){
                    grid[l][r+1] = 2;
                    count --;
                    queue.add(new int[]{l,r+1});
                }
            }
        }
        return count > 0 ? -1 : round;
    }

}
