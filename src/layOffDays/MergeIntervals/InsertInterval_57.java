package layOffDays.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/26 23:36
 */
public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        if (intervals.length == 0){
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }


        for (int i = 0; i<intervals.length; i++) {
            int[] tmp = intervals[i];
            if (tmp[0] >= newInterval[0]) {
                ans.add(newInterval);
            }
            ans.add(tmp);
        }
        if (intervals[intervals.length-1][0] < newInterval[0]) {
            ans.add(newInterval);
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i<ans.size(); i++) {
            int[] tmp = ans.get(i);
            int left = tmp[0], right = tmp[1];
            if (res.size() == 0 || res.get(res.size()-1)[1] < left) {
                res.add(tmp);
            }else {
                int[] last =  res.get(res.size()-1);
                last[1] = Math.max(right,last[1]);

            }
        }
        return res.toArray(new int[res.size()][]);


    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;
        int i = 0;

        while (i < len && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while (i < len) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[0][]);


    }
}
