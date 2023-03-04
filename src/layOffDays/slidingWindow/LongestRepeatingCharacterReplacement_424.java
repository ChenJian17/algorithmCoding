package layOffDays.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.slidingWindow
 * @Author: Joker
 * @CreateTime: 2023-03-03 23:27
 * @Description:
 */
public class LongestRepeatingCharacterReplacement_424 {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        int[] arr = new int[26];
        while (right < s.length()) {
            char c = s.charAt(right);
            arr[c - 'A'] += 1;
            max = Math.max(max, arr[c-'A']);

            if (k + max < right -left +1) {
                arr[s.charAt(left) - 'A'] --;
                left++;

            }
            right ++;
        }

        //Maximum sliding window is fixed
        return s.length() - left;
    }
}
