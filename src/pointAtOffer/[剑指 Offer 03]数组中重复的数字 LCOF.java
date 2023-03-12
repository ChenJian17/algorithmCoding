package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 数组 哈希表 排序 
// 👍 1105 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution03 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] - nums[i-1] == 0){
                return nums[i];
            }
        }
        return 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
