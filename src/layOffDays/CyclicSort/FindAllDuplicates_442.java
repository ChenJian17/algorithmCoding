package layOffDays.CyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/20 00:06
 */
public class FindAllDuplicates_442 {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i< nums.length; i++) {
            if (i != (nums[i]-1))
                res.add(nums[i]);
        }
        return res;

    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
