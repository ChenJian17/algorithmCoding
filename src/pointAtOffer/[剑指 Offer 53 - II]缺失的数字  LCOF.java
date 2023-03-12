package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 位运算 数组 哈希表 数学 二分查找 
// 👍 358 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        for (int i =0; i<nums.length; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
