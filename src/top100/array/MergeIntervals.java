package top100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/27 22:22
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0)
            return new int[0][2];

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals){
            int L = interval[0], R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size()-1)[1] < L){
                merged.add(interval);
            }else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }

}
