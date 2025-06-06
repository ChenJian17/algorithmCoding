package top100.greedy;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/5/6 17:53
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int border = 0, maxLen = 0;
        int step = 0;

        for (int i = 0; i<nums.length-1; i++){
            maxLen = Math.max(maxLen,nums[i]+i);
            if (i == border){
                border = maxLen;
                step ++;
            }
        }
        return step;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        JumpGame2 jumpGame2 = new JumpGame2();
        jumpGame2.jump(nums);
    }
}
