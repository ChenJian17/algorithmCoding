package layOffDays.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/9 23:00
 */
public class ConflictingAppointments_253 {
    public int canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i<n; i++) {
            if (i > 0 && intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();

    }
}
