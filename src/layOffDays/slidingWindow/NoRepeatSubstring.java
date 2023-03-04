package layOffDays.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.slidingWindow
 * @Author: Joker
 * @CreateTime: 2023-03-03 22:39
 * @Description:
 */
public class NoRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int left = 0, right = 0, sum = Integer.MIN_VALUE;
        Set<Character> box = new HashSet<>();
        char[] arr = s.toCharArray();
        while (right < arr.length) {
            if (box.contains(arr[right])) {
                while (arr[left] != arr[right]) {
                    box.remove(arr[left++]);
                }
                left++;
            }
            box.add(arr[right]);
            sum = Math.max(sum, right-left+1);
            right++;
        }
        return sum;


    }


}
