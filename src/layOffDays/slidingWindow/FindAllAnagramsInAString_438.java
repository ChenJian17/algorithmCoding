package layOffDays.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.slidingWindow
 * @Author: Joker
 * @CreateTime: 2023-03-06 22:23
 * @Description:
 */
public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] arr1 = new int[26], arr2 = new int[26];
        for (int i = 0; i<p.length(); i++) {
            arr1[s.charAt(i) - 'a'] ++;
            arr2[p.charAt(i) - 'a'] ++;
        }

        int left = 0,right = p.length()-1;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()){
            if (Arrays.equals(arr1,arr2)) {
                res.add(left);
            }
            arr1[s.charAt(left)-'a']--;
            left++;
            right++;
            if (right != s.length()){
                arr1[s.charAt(right)-'a']++;
            }
        }
        return res;

    }
}
