package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 二分查找 
// 👍 406 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i =0; i<nums.length; i++){
            if (nums[i] == target) {
                res ++;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
