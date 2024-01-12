package layOffDays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/25 23:51
 */
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i<intervals.length; i++){
            int left = intervals[i][0], right = intervals[i][1];

            if (merged.size() == 0) {
                merged.add(intervals[i]);
            }else {
                int[] tmp = merged.get(merged.size() - 1);
                if (tmp[1] < left) {
                    merged.add(intervals[i]);
                }else {
                    tmp[1] = Math.max(tmp[1],right);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }

}
