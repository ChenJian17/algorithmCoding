package top100.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/10 22:47
 */
public class LongestConsecutiveSequence_128 {

    public static int longestConsecutive(int[] nums) {
        if (nums.length <=1)
            return nums.length;

        Arrays.sort(nums);

        int left = 0, right = 1;
        int max = -1;
        int repeat = 0;
        while (right < nums.length) {
            int tmp = nums[right]-nums[right-1];
            if (tmp <= 1){
                right ++;
                if (tmp == 0) repeat++;
            }else {
                left=right;
                right++;
                repeat = 0;
            }
            max = Math.max(max,right-left-repeat);
        }
        return max;

    }

    public static int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num: set){
            if (!set.contains(num-1)){
                int curNum = num;
                int curStreak = 1;
                while (set.contains(curNum+1)){
                    curNum = curNum+1;
                    curStreak++;
                }
                longestStreak = Math.max(longestStreak,curStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,0,1};
        longestConsecutive(numbers);
    }
}
