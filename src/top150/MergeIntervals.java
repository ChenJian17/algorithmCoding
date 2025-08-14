package top150;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/29 22:26
 */
public class MergeIntervals {

    class Tmp {
        int a;
        int b;
        public Tmp(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
//    public  int[][] merge1(int[][] intervals){
//        List<Tmp> list = new ArrayList<>();
//        for(int i = 0; i<intervals.length; i++){
//            list.add(new Tmp(intervals[i][0],intervals[i][1]));
//        }
//        Collections.sort(list,(p,q) -> p.a-q.a);
//    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(p,q) -> p[0]-q[0]);
        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        for(int i = 1; i<intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(stack.peek()[1] >= left){
                int[] pop = stack.pop();
                stack.push(new int[]{pop[0],Math.max(pop[1],right)});
            }else {
                stack.push(intervals[i]);
            }
        }

        int[][] res = new int[stack.size()][2];
        for(int i = res.length-1; i>=0; i--){
            res[i] = stack.pop();
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        merge(arr);

    }

}
