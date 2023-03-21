package pointAtOffer;//English description is not available for the problem. Please switch to Chinese
//. 
// Related Topics 数组 双指针 二分查找 
// 👍 242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int[] res = new int[2];
        while (left < right){
            if ((nums[left]+nums[right]) > target){
                right --;
            }else if ((nums[left]+nums[right]) < target){
                left ++;
            }else {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
