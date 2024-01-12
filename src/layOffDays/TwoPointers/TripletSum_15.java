package layOffDays.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/4 21:54
 */
public class TripletSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return res;
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i<len; i++) {
            //排除最小值大于0的情况
            if (nums[i] > 0) break;
            //
            if (i>0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = len-1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重，只对纳入结果集的可能去重
                    //左边界去重
                    while (left<right && nums[left] == nums[left+1]) left++;
                    //右边界去重
                    while (left<right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else if (sum > 0) right--;
            }

        }
        return res;
    }
}
