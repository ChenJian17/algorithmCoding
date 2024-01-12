package layOffDays.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/11 23:14
 */

public class EmployeeFreeTime_759 {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> copy = new ArrayList<>();
        schedule.forEach(e -> copy.addAll(e));
        Collections.sort(copy, (a,b) -> a.start-b.start);
        Interval tmp = copy.get(0);
        for (Interval item : copy) {
            if (tmp.end < item.start) {
               res.add(new Interval(tmp.end, item.start));
               tmp = item;
            }else {
               tmp = tmp.end < item.end ? item : tmp;
            }
        }
        return res;

    }

}
