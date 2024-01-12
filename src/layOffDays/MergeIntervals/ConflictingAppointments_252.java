package layOffDays.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/3 22:43
 */
public class ConflictingAppointments_252 {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (i-1 >= 0 && intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;

    }

}
