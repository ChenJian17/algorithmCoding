package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/20 10:41
 */
public class MinSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int count = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            for(int j = i; j<nums.length; j++){
                sum += nums[j];
                if(sum >= target){
                    count = Math.min(count, j-i+1);
                    sum = 0;
                    break;
                }
            }
            sum = 0;
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }

    public int minSubArrayLen1(int target, int[] nums) {

        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(right < nums.length){
            sum += nums[right++];
            while(sum >= target){
                res = Math.min(res, right-left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        minSubArrayLen(target,nums);

    }
}
