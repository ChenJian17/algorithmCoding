package layOffDays.KWaymerge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/5 17:52
 */
public class KthSmallestNumSortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {

        Queue<Pair> queue = new PriorityQueue<>((a,b) -> a.value-b.value);
        for (int i = 0; i<matrix.length; i++){
            queue.add(new Pair(matrix[i][0],i,0));
        }

        int count = 0, i = 0,j =0;
        while (count < k && !queue.isEmpty()) {
            Pair pair = queue.poll();
            i = pair.i;
            j = pair.j;
            if ((j+1)<matrix[i].length) {
                queue.add(new Pair(matrix[i][j+1],i,j+1));
            }
            count++;
        }
        return matrix[i][j];

    }

    class Pair {
        int value,i,j;

        public Pair(int value, int i, int j){
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        KthSmallestNumSortedMatrix_378 test = new KthSmallestNumSortedMatrix_378();
        int vl = test.kthSmallest(matrix,8);
        System.out.println(vl);
    }
}
