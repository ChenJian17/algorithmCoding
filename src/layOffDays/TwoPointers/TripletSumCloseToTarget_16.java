package layOffDays.TwoPointers;

import java.util.Arrays;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2023/9/5 22:48
 */
public class TripletSumCloseToTarget_16 {
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        if ((target > 0 && target <= nums[0]) ||
                (target < 0 && target >= nums[nums.length-1])) {
            return nums[0]+nums[1]+nums[2];
        }
        if ((target > 0 && target >= nums[nums.length-1]) ||
                (target < 0 &&  target <= nums[0])) {
            return nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i<nums.length; i++){

            int left = i+1, right = nums.length-1;

            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum < target) {
                    left++;
                }else if (sum > target) {
                    right--;
                }else {
                    return sum;
                }

                if (Math.abs(target-sum) < Math.abs(target-res)) {
                    res = sum;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100,-98,-2,-1};

        System.out.println(threeSumClosest(nums, -101));
    }

}
