package layOffDays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays
 * @Author: Joker
 * @CreateTime: 2023-03-01 21:50
 * @Description:
 */
public class LongestSubstringWithKDistinctCharacters {
    int slidingWindow(String s, int k) {
        char[] tmp = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, sum = -1;

        while(right < tmp.length) {
            map.put(tmp[right],map.getOrDefault(tmp[right],0)+1);
            if(map.size() == k) {
                sum = Math.max(sum, right - left +1);
            }
            while (map.size() > k){
                map.put(tmp[left],map.get(tmp[left])-1);
                if (map.get(tmp[left]) <= 0) {
                    map.remove(tmp[left]);
                }
                left ++;
            }
            right++;

        }
        return sum;


    }
}
