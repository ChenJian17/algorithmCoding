package top100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/8 23:40
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int left = target-nums[i];
            if (map.containsKey(left)){
                return new int[]{map.get(left),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};

    }
}
