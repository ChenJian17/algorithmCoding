package layOffDays.CyclicSort;

import java.util.*;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/15 23:21
 */
public class FindAllMissingNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j<nums.length; j++) {
            set.add(nums[j]);
        }

        for (int i =1; i<= nums.length; i++) {
            if (!set.contains(i))
                res.add(i);
        }
        return res;


    }
}
