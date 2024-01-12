package layOffDays.TwoPointers;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/3 22:53
 */
public class SquaringSortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            ans[i] = nums[i]*nums[i];
        }
        Arrays.sort(ans);
        return ans;

    }
}
