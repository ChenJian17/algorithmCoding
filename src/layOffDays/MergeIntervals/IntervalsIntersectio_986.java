package layOffDays.MergeIntervals;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/29 22:23
 */
public class IntervalsIntersectio_986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> res = new ArrayList<>();
        int left = 0, right = 0;
        while (left < firstList.length && right < secondList.length) {
            if (firstList[left][0] <= secondList[right][0]) {
                res.add(firstList[left++]);
            }else {
                res.add(secondList[right++]);
            }
        }

        while (left < firstList.length){
            res.add(firstList[left++]);
        }

        while (right < secondList.length){
            res.add(secondList[right++]);
        }


        List<int[]> ans = new ArrayList<>();
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i<res.size(); i++) {
            int[] l1 = res.get(i);

            if (ans.size() == 0 || ans.get(ans.size()-1)[1] < l1[0]){
                ans.add(res.get(i));
            }else {
                int[] and = new int[2];
                and[0] = l1[0];
                and[1] = Math.min(l1[1], ans.get(ans.size()-1)[1]);
                tmp.add(and);
                if (ans.get(ans.size()-1)[1] < l1[1]){
                    ans.add(res.get(i));
                }

            }
        }
        return tmp.toArray(new int[0][]);
    }


    public static int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right){
                res.add(new int[]{left,right});
            }
            if (firstList[i][1] > secondList[j][1]){
                j++;
            }else {
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }

        public static void main(String[] args) {
        int[][] firstList = {{8,15}};
        int[][] secondList = {{2,6},{8,10},{12,20}};
        intervalIntersection(firstList,secondList);

    }
}
