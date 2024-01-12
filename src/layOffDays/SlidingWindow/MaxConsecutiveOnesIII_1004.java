package layOffDays.SlidingWindow;

/**
 * @BelongsProject: algorithmCoding
 * @BelongsPackage: layOffDays.slidingWindow
 * @Author: Joker
 * @CreateTime: 2023-03-04 21:17
 * @Description:
 */
public class MaxConsecutiveOnesIII_1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, res = Integer.MIN_VALUE;
        int[] map = new int[2];
        while (right < nums.length) {
            map[nums[right]] ++;
            if (map[0] > k) {
                res = Math.max(right -left, res);
                map[nums[left]]--;
                left ++;
            }
            res = Math.max(right -left+1, res);

            right ++;
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
