package layOffDays.TopKElements;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/7/26 22:34
 */
public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });

        for (int i = 0; i<k; i++){
            queue.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1],i});
        }

        int n = points.length;
        for (int i = k; i<n; i++){
            int dist = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if (dist < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{dist,i});
            }
        }
        int[][] ans = new int[k][2];
        for (int i= 0; i<k; i++){
            ans[i] = points[queue.poll()[0]];
        }

        return ans;
    }

    public int[][] kClosest1(int[][] points, int k){
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1]) - (o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        return Arrays.copyOfRange(points,0,k);
    }

}
