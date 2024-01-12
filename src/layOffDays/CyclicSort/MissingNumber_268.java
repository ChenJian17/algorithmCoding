package layOffDays.CyclicSort;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/10/13 23:44
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) ans ^= i;
        for (int i : nums) ans ^= i;
        return ans;
    }
}
