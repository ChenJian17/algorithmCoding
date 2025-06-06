package top100.greedy;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/4 23:17
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int maxLen = 0;

        for (int i = 0; i<nums.length; i++){
            maxLen = Math.max(maxLen, nums[i]+i);
            if (maxLen <= i){
                if (nums[i] == 0 && i !=nums.length-1)
                    return false;
            }
        }
        return true;
    }

    public boolean canJump1(int[] nums){
        int maxLen = 0;
        for (int i = 0; i<nums.length; i++){
            // 前面能跳到的最远位置小于当前位置时
            // 必须放在前面判断,max表示0到i-1中能跳到的最远位置，i表示当前位置
            if (maxLen < i){
                return false;
            }
            maxLen = Math.max(maxLen, nums[i]+i);

        }
        return true;
    }
}
