package layOffDays.TwoPointers;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/8 21:49
 */
public class SubarraysLessThanTarget_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int res = 0;
        for (int i = 0; i<nums.length; i++) {
            int ans = i,sum = 1;
            while (ans < nums.length) {
                sum *= nums[ans];
                if (sum < k) res++;
                else break;
                ans++;
            }
        }
        return res;

    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, right = 0;
        int ans =0, sum = 1;
        while (right < nums.length) {
            sum *= nums[right];
            while (sum >= k) {
                sum /= nums[left];
                left ++;
            }

            ans = right-left+1;
            right ++;
        }
        return ans;
    }
}
