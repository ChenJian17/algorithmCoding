package top150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/8/14 20:15
 */
public class InsertInterval {

    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++){
            list.add(intervals[i]);
        }
        list.add(newInterval);
        list.sort((p,q) -> p[0]-q[0]);

        List<int[]> merged = new ArrayList<>();

        for(int i = 0; i<list.size(); i++){
            int left = list.get(i)[0],right = list.get(i)[1];
            if(i == 0 || left > merged.get(merged.size()-1)[1]){
                merged.add(list.get(i));
            }else if(left <= merged.get(merged.size()-1)[1]){
                merged.get(merged.size()-1)[0] = Math.min(merged.get(merged.size()-1)[0],left);
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],right);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        Stack<int[]> stack = new Stack<>();

        int left = newInterval[0], right = newInterval[1];
        boolean flag = false;
        for(int i = 0; i<intervals.length; i++){
            if (flag){
                if(intervals[i][0] <= stack.peek()[1]){
                    calcute(stack,intervals[i]);
                }else{
                    stack.push(intervals[i]);
                }

            }else {
                stack.push(intervals[i]);
                if(left <= stack.peek()[1]){
                    calcute(stack,newInterval);
                    flag = true;
                }
            }

        }

        if(!flag){
            stack.push(newInterval);
        }


        int[][] res = new int[stack.size()][2];
        for(int i = stack.size()-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;


    }

    public static void calcute(Stack<int[]> stack, int[] newInterval){
        int[] tmp = newInterval;
        while(!stack.isEmpty()){
            if(tmp[0] <= stack.peek()[1]){
                int[] pop = stack.pop();
                tmp = new int[]{Math.min(tmp[0],pop[0]),Math.max(tmp[1],pop[1])};
            }else{
                stack.push(tmp);
                break;
            }
        }
        if(stack.isEmpty()){
            stack.push(tmp);
        }


    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInter = new int[]{2,5};
        insert1(intervals,newInter);


    }
}
