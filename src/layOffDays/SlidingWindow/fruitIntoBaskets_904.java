package layOffDays.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.slidingWindow
 * @Author: Joker
 * @CreateTime: 2023-03-02 23:20
 * @Description:
 */
public class fruitIntoBaskets_904 {
    static int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        while (right < fruits.length) {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while (map.size() > 2) {
                map.put(fruits[left],map.get(fruits[left])-1);
                left++;
                if (map.get(fruits[left]) <= 0){
                    map.remove(fruits[left]);
                }
            }
            res = Math.max(res, right - left +1);
            right++;
        }
        return res == Integer.MIN_VALUE ? 0 : res;

    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        totalFruit(arr);

    }
}
