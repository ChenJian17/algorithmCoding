package layOffDays.TwoPointers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/2 22:17
 */
public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int i = 0;
        for (int tmp: set) {
            nums[i++] = tmp;
        }
        return set.size();

    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left+1] = nums[right];
            }
            right++;
        }
        return left+1;

    }


    public static void main(String[] args) {

    }
}
