package top100.array;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/8/24 23:11
 */
public class MaxSubarray {
    public int maxSubArray(int[] nums) {

        int res = Integer.MIN_VALUE;
        int preSum = 0, minPreSum = 0;
        for (int num : nums){
            preSum += num;
            res = Math.max(res, preSum-minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
            // 存在这么一种case：包含这个下标以内的所有前缀和的最小值等于该下标的前缀和
            // 这种case下的preSum-minPreSum 相当于结果子数组为空
            // 因为题目要求子数组不为空，为了避免这种情况，所以要先计算出子数组结果和res后再计算minPreSum
        }
        return res;

    }

    public int maxSubArray1(int[] nums) {
        int[] fi = new int[nums.length];
        fi[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i<nums.length; i++){
            fi[i] = Math.max(fi[i-1],0)+nums[i];
            ans = Math.max(fi[i],ans);
        }
        return ans;
    }
}
